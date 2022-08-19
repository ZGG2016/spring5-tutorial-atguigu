package ioc.demo6;


public class UserService {

    // 1. 创建 UserDao 类型属性，生成 set 方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("add.................");
        // 调用
        this.userDao.update();
    }
}
