package ioc.demo18;

import ioc.demo18.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于注解方式实现属性注入
 * （1）@Autowired：根据属性类型进行自动装配
 *      - 创建 service 和 dao 类，在 service 和 dao 类添加创建对象注解
 *      - 在 service 类添加 dao 类型属性，在属性上面使用注解
 * （2）@Qualifier：根据名称进行注入
 *      和上面 @Autowired 一起使用
 *      （比如，有多个 UserDao 接口的实现类，如果仅仅根据属性类型注入，则会找到多个，报错(Could not autowire. There is more than one bean of 'UserDao' type.)）
 * （3）@Value：注入普通类型属性
 */
public class TestClass {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo18/demo18.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }
}
