package aop.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP 操作（AspectJ 注解）
 */
public class TestClass {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo2/demo2.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
