package com.zgg.demo3.service.impl;


import com.zgg.demo3.entity.User;
import com.zgg.demo3.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserServiceImpl implements UserService {

    //创建map集合存储数据
    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("lucy", "nan", 20));
        this.users.put(2, new User("mary", "nv", 30));
        this.users.put(3, new User("jack", "nv", 50));
    }

    @Override
    public Mono<User> findUserById(int id) {
        /*
         * return data != null && data.isPresent() ? just(data.get()) : empty();
         * 数据不是null，且有数据，那么就 创建一个Mono，用来提交这个数据，否则就 不提交任何数据就完成
         * */
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> findAllUser() {
        // 创建一个 flux，用来提交iterable中的数据
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUser(Mono<User> user) {
        /*
        * doOnNext: 给 Mono 添加一个行为，这个行为在 Mono 成功提交一个数据时触发。
        * thenEmpty: 返回一个 Mono<Void>, Mono<Void> 等待调用它的这个 Mono 完成，然后等待提供的 Publisher 完成。重新播放第二个完成信号，或者任何错误信号。
        * */
        return user.doOnNext(person -> {
            int id = this.users.size();
            users.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
