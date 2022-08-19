package ioc.demo13;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 作用域: 创建的 bean 实例是单实例还是多实例
 *
 * 在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例
 *    - singleton，默认值，表示是单实例对象
 *    - prototype，表示是多实例对象
 *
 * singleton 和 prototype 区别
 *    第一 singleton 单实例，prototype 多实例
 *    第二 设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象
 *        设置 scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建 对象，在调用 getBean 方法时候创建多实例对象
 *
 */
public class TestClass {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo13/demo13.xml");
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);

        System.out.println(student1);  // 地址不同
        System.out.println(student2);
        System.out.println("------------------");
        System.out.println(book1);  // 地址相同
        System.out.println(book2);
    }
}
