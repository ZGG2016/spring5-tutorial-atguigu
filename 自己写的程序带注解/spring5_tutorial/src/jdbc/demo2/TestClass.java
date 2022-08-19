package jdbc.demo2;

import jdbc.demo2.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * 事务添加到 JavaEE 三层结构里面 Service 层（业务逻辑层）
 * 在 Spring 进行事务管理操作
 *   （1）有两种方式：编程式事务管理和声明式事务管理（使用）
 * 声明式事务管理
 *   （1）基于注解方式（使用）
 *   （2）基于 xml 配置文件方式
 * 在 Spring 进行声明式事务管理，底层使用 AOP 原理
 * Spring 事务管理 API
 *   （1）提供一个接口，代表事务管理器，这个接口针对不同的框架提供不同的实现
 * */
public class TestClass {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/demo2/demo2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferMoney();

    }
}
