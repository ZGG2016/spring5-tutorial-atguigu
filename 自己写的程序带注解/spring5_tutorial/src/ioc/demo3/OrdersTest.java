package ioc.demo3;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 xml 方式注入属性:
 *     第二种注入方式：使用有参数构造进行注入
 */
public class OrdersTest {
    @Test
    public void test() {
        // 1 加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo3/bean3.xml");
        // 2 获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.getInfo();
    }
}
