package aop.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 2. 创建增强类（编写增强逻辑）
// 6. 在增强类上面添加注解 @Aspect
@Aspect  // 生成代理对象
@Component
public class UserProxy {

    // 前置通知
    // @Before 注解表示作为前置通知
    // 8. 在增强类的里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置
    @Before(value = "execution(* User.add(..))")
    public void before(){
        System.out.println("before..........");
    }

    //后置通知（返回后通知）
    @AfterReturning(value = "execution(* User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }
    //最终通知
    @After(value = "execution(* User.add(..))")
    public void after() {
        System.out.println("after.........");
    }
    //异常通知
    @AfterThrowing(value = "execution(* User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }
    //环绕通知
    @Around(value = "execution(* User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws
            Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
    }

}
