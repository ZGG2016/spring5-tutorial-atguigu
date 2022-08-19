package ioc.demo6;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：外部 bean
 */
public class UserTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo6/demo6.xml");
        UserService userservice = context.getBean("userservice", UserService.class);

        System.out.println(userservice);
        userservice.add();

    }
}
