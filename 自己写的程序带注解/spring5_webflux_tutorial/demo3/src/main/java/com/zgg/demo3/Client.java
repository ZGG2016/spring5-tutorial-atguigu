package com.zgg.demo3;

import com.zgg.demo3.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {
    public static void main(String[] args) {
        // 调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:59952");

        // 根据id查询
        String id = "1";
        User user = webClient
                .get()   // 构建一个 http get 请求
                .uri("/users/{id}", id)  // 请求这个地址
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()  // 取到响应
                .bodyToMono(User.class) // 把响应体转成User类型的Mono
                .block();  // 订阅此Mono并无限期阻塞，直到接收到下一个信号
        if (user != null) {
            System.out.println(user.getName());
        }

        // 查询所有
        Flux<User> users = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);
        users.map(User::getName)   // 通过在此Flux发出的每一项上应用提供的函数进行转换
                .buffer()  // 将所有传入的值收集到单个List缓冲区中，一旦该Flux完成，将由返回的Flux发出
                .doOnNext(System.out::println)  // Flux提交一项时，触发的行为
                .blockFirst(); // 订阅该Flux并无限阻塞，直到上游发送其第一个值或完成
    }
}
