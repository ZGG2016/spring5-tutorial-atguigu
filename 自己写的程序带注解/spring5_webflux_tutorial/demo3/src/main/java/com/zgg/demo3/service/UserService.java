package com.zgg.demo3.service;


import com.zgg.demo3.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// 用户操作接口
public interface UserService {

    // 根据id查询用户
    Mono<User> findUserById(int id);

    // 查询所有用户
    Flux<User> findAllUser();

    // 添加用户
    Mono<Void> saveUser(Mono<User> user);
}
