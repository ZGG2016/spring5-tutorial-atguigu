package jdbc.demo1.dao;

import jdbc.demo1.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(Integer userId, String userStatus);

    void deleteUser(Integer userId);

    int findCount();

    User findObject(Integer userId);

    List<User> findAllObject();

    void addUsersBatch(List<Object[]> users);

    void updateUsersBatch(List<Object[]> users);

    void deleteUserBatch(List<Object[]> ids);
}
