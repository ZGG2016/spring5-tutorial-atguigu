package ioc.demo9;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：数组、list、map、set 类型属性
 */
public class StudentTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo9/demo9.xml");
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }
}
