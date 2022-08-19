package ioc.demo14;


import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 生命周期: 从对象创建到对象销毁的过程
 *
 * bean 生命周期创建：
 * （1）通过构造器创建 bean 实例（无参数构造）
 * （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
 * （3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
 * （4）调用 bean 的初始化的方法（需要进行配置初始化的方法）
 * （5）把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization
 * （6）bean 可以使用了（对象获取到了）
 * （7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
 *
 */
public class TestClass {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo14/demo14.xml");

        Object orders = context.getBean("orders");
        System.out.println("第四步：bean 可以使用了（对象获取到了）");
        System.out.println(orders);

        context.close();
    }
}
