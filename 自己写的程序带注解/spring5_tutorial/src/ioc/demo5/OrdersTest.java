package ioc.demo5;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 基于 xml 方式注入属性:
 *     xml 注入其他类型属性：空值  特殊符号
 */
public class OrdersTest {
    @Test
    public void test() {
        // 1 加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo5/bean5.xml");
        // 2 获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.getInfo();
    }
}
