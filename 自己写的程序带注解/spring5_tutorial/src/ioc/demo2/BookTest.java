package ioc.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 xml 方式注入属性:
 *     第一种注入方式：使用 set 方法进行注入
 */
public class BookTest {
    @Test
    public void test() {
        // 1 加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo2/bean2.xml");
        // 2 获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.getInfo();
    }
}
