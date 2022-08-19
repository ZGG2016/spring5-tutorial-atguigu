package jdbc.demo4;

import jdbc.demo4.config.TxConfig;
import jdbc.demo4.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * 声明式事务管理: 完全注解开发
 * */
public class TestClass {
    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferMoney();

    }
}
