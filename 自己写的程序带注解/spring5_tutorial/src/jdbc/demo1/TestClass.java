package jdbc.demo1;

import jdbc.demo1.entity.User;
import jdbc.demo1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/demo1/demo1.xml");
        UserService userService = context.getBean("userService", UserService.class);

//        User user1 = new User(1,"zhangsan","online");
//        User user2 = new User(2,"lisi","offline");
//
//        userService.addUser(user1);
//        userService.addUser(user2);

//        userService.updateUser(2,"online");
//        userService.deleteUser(1);

//        int count = userService.findCount();
//        System.out.println(count);

//        userService.findObject(1);

//        userService.findAllObject();

//        List<Object[]> users = new ArrayList<>();
//        Object[] o1 = {3,"wangwu","online"};
//        Object[] o2 = {4,"chenliu","offline"};
//        users.add(o1);
//        users.add(o2);
//        userService.addUsersBatch(users);

//        List<Object[]> users = new ArrayList<>();
//        Object[] o1 = {"wangwu", "offline", 3};
//        Object[] o2 = {"chenliu", "online", 4};
//        users.add(o1);
//        users.add(o2);
//        userService.updateUsersBatch(users);

        List<Object[]> ids = new ArrayList<>();
        Object[] o1 = {3};
        Object[] o2 = {4};
        ids.add(o1);
        ids.add(o2);
        userService.deleteUserBatch(ids);


    }
}
