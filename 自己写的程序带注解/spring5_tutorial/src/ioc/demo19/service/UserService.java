package ioc.demo19.service;

import ioc.demo19.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value(value = "zhangsan")
    private String name;

    //定义 dao 类型属性
    //不需要添加 set 方法
    //添加注入属性注解
    @Autowired   //根据类型进行注入
    @Qualifier(value = "userDaoImpl1")   //根据名称进行注入
    private UserDao userDao;



    public void add(){
        System.out.println("user service add..............." + name);
        userDao.add();
    }
}
