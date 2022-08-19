package aop.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 使用 JDK 动态代理，使用 Proxy 类里面的方法创建代理对象  （创建接口实现类的代理对象）
 */
public class JDKProxy {
    public static void main(String[] args) {

        UserDaoImpl1 daoImpl1 = new UserDaoImpl1();
        // 创建接口实现类的代理对象
        UserDao proxyInstance = (UserDao)Proxy.newProxyInstance(UserDaoImpl1.class.getClassLoader(),
                new Class[]{UserDao.class},
                new MyInvocationHandler(daoImpl1));
        int add = proxyInstance.add(1, 2);
        System.out.println(add);
        System.out.println("--------------------------");

        String update = proxyInstance.update("zhangsan");
        System.out.println(update);
    }


    private static class MyInvocationHandler implements InvocationHandler {

        //  把创建的是谁的代理对象，把谁传递过来
        //  有参数构造传递
        private UserDao userDao;

        public MyInvocationHandler(UserDao userDao) {
            this.userDao = userDao;
        }

        // 增强的逻辑
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //方法之前
            System.out.println("args: " + Arrays.toString(args));
            System.out.println("method: " + method.getName());
            System.out.println("方法执行之前");

            //被增强的方法执行
            Object res = null;
            String methodName = method.getName();
            if ("add".equals(methodName)){
                res = method.invoke(userDao, args);
            }else if ("update".equals(methodName)){
                res = method.invoke(userDao, args);
            }

            //方法之后
            System.out.println("方法执行之后");

            return res;
        }
    }
}
