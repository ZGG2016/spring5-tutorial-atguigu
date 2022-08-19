package jdbc.demo2.service;

import jdbc.demo2.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
* 3. 在 service 类上面（或者 service 类里面方法上面）添加事务注解
 * （1）@Transactional，这个注解添加到类上面，也可以添加方法上面
 * （2）如果把这个注解添加类上面，这个类里面所有的方法都添加事务
 * （3）如果把这个注解添加方法上面，为这个方法添加事务
* */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ, timeout = -1, readOnly = false)
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
