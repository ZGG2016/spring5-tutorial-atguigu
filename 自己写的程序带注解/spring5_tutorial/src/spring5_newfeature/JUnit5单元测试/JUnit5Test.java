package spring5_newfeature.JUnit5单元测试;

import jdbc.demo3.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)  //单元测试框架
//@ContextConfiguration("classpath:jdbc/demo3/demo3.xml")  //加载配置文件

// 使用一个复合注解替代上面两个注解完成整合
@SpringJUnitConfig(locations = "classpath:jdbc/demo3/demo3.xml")
public class JUnit5Test {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.transferMoney();
    }
}
