package jdbc.demo3.service;

import jdbc.demo3.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    // 注入 dao
    @Autowired
    private UserDao userDao;

    // 转账的方法
    public void transferMoney(){
        // zhangsan 少100
        userDao.reduceMoney();

        int a = 100/0;

        // lisi 多100
        userDao.addMoney();
    }
}
