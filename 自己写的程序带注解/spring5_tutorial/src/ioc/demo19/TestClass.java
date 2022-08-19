package ioc.demo19;

import ioc.demo19.config.SpringConfig;
import ioc.demo19.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 完全注解开发: 创建配置类，替代 xml 配置文件
 */
public class TestClass {
    @Test
    public void test(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

}
