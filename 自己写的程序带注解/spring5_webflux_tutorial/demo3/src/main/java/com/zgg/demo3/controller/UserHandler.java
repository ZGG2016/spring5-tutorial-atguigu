package com.zgg.demo3.controller;

import com.zgg.demo3.entity.User;
import com.zgg.demo3.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    // 根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        // 从请求连接中取出名为id的路径变量
        int id = Integer.parseInt(serverRequest.pathVariable("id"));

        /*
           notFound(): 创建状态为404 Not Found的HeadersBuilder
           HeadersBuilder: 将一个headers添加到响应中
           build(): 构建一个没有body的响应实体
         */

        // id为空值时的处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        // 调用service方法得到数据
        Mono<User> user = this.userService.findUserById(id);

        /*
           ok(): 创建状态为200 ok的BodyBuilder
           BodyBuilder: 将一个body添加到响应中

           fromValue: 将传入的数据封装成BodyInserter, 它可以写给定的值

           body: 根据BodyInserter创建一个BodyInserterResponse对象，再调用Mono的just方法，返回Mono<ServerResponse>对象
         */

        // 把userMono进行转换返回，使用Reactor操作符flatMap
        Mono<ServerResponse> responseMono = user.flatMap(
                        person -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(fromValue(person)))
                .switchIfEmpty(notFound);
        return responseMono;

    }

    // 查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest){
        Flux<User> allUser = this.userService.findAllUser();
        // body: Set the body from the given Publisher.
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUser, User.class);
    }

    // 添加
    public Mono<ServerResponse> saveUser(ServerRequest serverRequest){
        // bodyToMono(): Extract the body to a Mono.
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        // build(): Build the response entity with no body. The response will be committed when the given voidPublisher completes.
        return ServerResponse.ok().build(this.userService.saveUser(userMono));

    }
}
