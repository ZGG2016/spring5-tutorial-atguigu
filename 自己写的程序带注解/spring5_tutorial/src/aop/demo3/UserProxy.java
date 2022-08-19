package aop.demo3;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class UserProxy {

    // 相同的切入点抽取
    @Pointcut(value = "execution(* User.add(..))")
    public void point(){}

    @Before(value = "point()")
    public void before(){
        System.out.println("user before..........");
    }

    @After(value = "point()")
    public void after() {
        System.out.println("user after.........");
    }
}
