package aop.demo4;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP 操作（XML）
 */
public class TestClass {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo4/demo4.xml");
        Book book = context.getBean("book", Book.class);
        book.add();
    }
}
