package ioc.demo12;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1、Spring 有两种类型 bean，一种普通 bean，另外一种工厂 bean（FactoryBean）
 * 2、普通 bean：在配置文件中定义 bean 类型就是返回类型
 * 3、工厂 bean：在配置文件定义 bean 类型可以和返回类型不一样
 *    第一步 创建类，让这个类作为工厂 bean，实现接口 FactoryBean
 *    第二步 实现接口里面的方法，在实现的方法中定义返回的 bean 类型
 */
public class BeanTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo12/demo12.xml");
        MyCommonBean myCommonBean = context.getBean("mycommonbean", MyCommonBean.class);
        System.out.println(myCommonBean);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo12/demo12.xml");
        Course course = context.getBean("myfactorybean", Course.class);
        System.out.println(course);

    }
}
