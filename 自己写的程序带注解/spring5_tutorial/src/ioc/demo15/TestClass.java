package ioc.demo15;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配: 根据指定装配规则（属性名称或者属性类型），Spring 自动将匹配的属性值进行注入
 */
public class TestClass {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo15/demo15.xml");
        Employee employee = context.getBean("employee", Employee.class);

        System.out.println(employee);
    }
}
