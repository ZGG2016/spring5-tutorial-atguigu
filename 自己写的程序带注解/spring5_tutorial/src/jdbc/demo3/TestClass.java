package jdbc.demo3;

import jdbc.demo3.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * 声明式事务管理
 *   （1）基于注解方式
 *   （2）基于 xml 配置文件方式（使用）
 * */
public class TestClass {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/demo3/demo3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferMoney();

    }
}
