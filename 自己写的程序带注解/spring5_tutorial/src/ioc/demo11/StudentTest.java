package ioc.demo11;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：把集合注入部分提取出来，作公共部分   （同时给 Student Book 使用）
 */
public class StudentTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo11/demo11.xml");
        Student student = context.getBean("student", Student.class);
        Book book = context.getBean("book", Book.class);

        System.out.println(student);
        System.out.println("------------------");
        System.out.println(book);
    }
}
