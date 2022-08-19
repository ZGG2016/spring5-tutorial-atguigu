package jdbc.demo3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImp implements UserDao {

    // 注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql = "update t_account set money=money-? where user_id=?";
        jdbcTemplate.update(sql, 100, 1);
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money+? where user_id=?";
        jdbcTemplate.update(sql, 100, 2);
    }
}
