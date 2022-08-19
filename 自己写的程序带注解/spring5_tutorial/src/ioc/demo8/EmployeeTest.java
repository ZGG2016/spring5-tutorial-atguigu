package ioc.demo8;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：级联赋值
 */
public class EmployeeTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo8/demo8.xml");
        Employee employee = context.getBean("employee", Employee.class);

        System.out.println(employee);
    }
}
