package aop.demo2;

import org.springframework.stereotype.Component;

// 1. 创建类，在类里面定义方法
// 5. 使用注解创建 User 和 UserProxy 对象
@Component
public class User {
    public void add() {
//        int a = 11 / 0;
        System.out.println("add.........");
    }
}
