package jdbc.demo1.service;

import jdbc.demo1.dao.UserDao;
import jdbc.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // 注入 userDao
    @Autowired
    private UserDao userDao;

    // 添加
    public void addUser(User user) {
        userDao.addUser(user);
    }

    // 修改
    public void updateUser(Integer userId, String userStatus) {
        userDao.updateUser(userId, userStatus);
    }

    // 删除
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    // 查看表有多少条记录（查询返回某个值）
    public int findCount() {
        return userDao.findCount();
    }

    // 查询返回对象
    public void findObject(Integer userId) {
        User user = userDao.findObject(userId);
        System.out.println(user);
    }

    // 查询返回集合
    public void findAllObject() {
        List<User> users = userDao.findAllObject();
        System.out.println(users);
    }

    // 批量添加
    public void addUsersBatch(List<Object[]> users){
        userDao.addUsersBatch(users);
    }

    // 批量修改
    public void updateUsersBatch(List<Object[]> users){
        userDao.updateUsersBatch(users);
    }

    // 批量删除
    public void deleteUserBatch(List<Object[]> ids){
        userDao.deleteUserBatch(ids);
    }
}
