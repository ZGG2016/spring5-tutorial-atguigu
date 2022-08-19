package aop.demo3;

import ioc.demo19.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP 操作（AspectJ 注解）
 *   - 相同的切入点抽取
 *   - 有多个增强类多同一个方法进行增强，设置增强类优先级
 *   - 完全使用注解开发
 */
public class TestClass {

    @Test
    public void test(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}
