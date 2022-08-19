package com.zgg.demo2.controller;


import com.zgg.demo2.entity.User;
import com.zgg.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// 携带该注解的类被视为控制器
@RestController
public class UserController {
    //注入service
    @Autowired
    private UserService userService;

    /*
    * @GetMapping: 将 HTTP GET 请求映射到特定的 handler 方法
    * @PathVariable: 让指定的参数和 url 关联
    * */
    // 根据 id 查询用户
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    // 查询所有
    @GetMapping("/user")
    public Flux<User> getAllUsers() {
        return userService.findAllUser();
    }

    // 添加
    // @RequestBody: 将方法参数应该绑定到web请求正文
    @PostMapping("/saveuser")
    public Mono<Void> saveOneUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.saveUser(userMono);
    }
}
