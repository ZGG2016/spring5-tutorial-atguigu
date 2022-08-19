package ioc.demo17;

import ioc.demo17.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1、注解是代码特殊标记
 *   - 格式：@注解名称(属性名称=属性值, 属性名称=属性值..)
 *   - 使用注解，注解作用在类上面，方法上面，属性上面
 *   - 使用注解目的：简化 xml 配置
 * 2、Spring 针对 Bean 管理中【创建对象提供注解】
 * （1）@Component
 * （2）@Service
 * （3）@Controller
 * （4）@Repository
 * * 上面四个注解功能是一样的，都可以用来创建 bean 实例
 */
public class TestClass {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo17/demo17.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }
}
