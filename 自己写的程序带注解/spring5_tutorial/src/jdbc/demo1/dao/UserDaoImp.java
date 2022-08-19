package jdbc.demo1.dao;

import jdbc.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    // 注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //  在 dao 进行数据库添加操作
    //  调用 JdbcTemplate 对象里面 update 方法实现添加操作
    @Override
    public void addUser(User user) {
        String sql = "insert into T_USER VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserStatus());
        System.out.println(update);
    }

    @Override
    public void updateUser(Integer userId, String userStatus) {
        String sql = "update T_USER set userstatus=? where user_id=?";
        int update = jdbcTemplate.update(sql, userStatus, userId);
        System.out.println(update);
    }

    @Override
    public void deleteUser(Integer userId) {
        String sql = "delete from T_USER where user_id=?";
        int update = jdbcTemplate.update(sql, userId);
        System.out.println(update);
    }

    @Override
    public int findCount() {
        String sql = "select count(*) from T_USER";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public User findObject(Integer userId) {
        String sql = "select * from T_USER where user_id=?";
        // 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成数据封装
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userId);
        return user;
    }

    @Override
    public List<User> findAllObject() {
        String sql = "select * from T_USER";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    // 遍历 users 列表，分别执行 sql 语句
    @Override
    public void addUsersBatch(List<Object[]> users) {
        String sql = "insert into T_USER VALUES(?,?,?)";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, users);
        System.out.println(Arrays.toString(batchUpdate));
    }

    @Override
    public void updateUsersBatch(List<Object[]> users) {
        String sql = "update T_USER set username=?,userstatus=? where user_id=?";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, users);
        System.out.println(Arrays.toString(batchUpdate));

    }

    @Override
    public void deleteUserBatch(List<Object[]> ids) {
        String sql = "delete from T_USER where user_id=?";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, ids);
        System.out.println(batchUpdate);
    }
}
