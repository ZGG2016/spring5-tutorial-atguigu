package ioc.demo12;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Course> {

//    工厂 bean：在配置文件定义 bean 类型可以和返回类型不一样
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCourseName("Java教程");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
