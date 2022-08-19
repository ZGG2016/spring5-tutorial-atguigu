package aop.demo3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 在增强类上面添加注解 @Order(数字类型值)，数字类型值越小优先级越高
@Order(1)
@Aspect
@Component
public class PersonProxy {

    @Before(value = "execution(* User.add(..))")
    public void before(){
        System.out.println("person before..........");
    }

}
