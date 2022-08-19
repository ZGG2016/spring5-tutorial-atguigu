package aop.demo3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"aop.demo3"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}