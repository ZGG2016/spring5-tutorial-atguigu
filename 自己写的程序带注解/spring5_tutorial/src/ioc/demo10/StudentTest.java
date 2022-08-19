package ioc.demo10;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：list ,列表元素是一个对象
 */
public class StudentTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo10/demo10.xml");
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }
}
