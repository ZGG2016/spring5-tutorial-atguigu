package ioc.demo7;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：内部 bean
 */
public class EmployeeTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo7/demo7.xml");
        Employee employee = context.getBean("employee", Employee.class);

        System.out.println(employee);
    }
}
