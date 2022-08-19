package spring5_newfeature.Nullable注解;

import org.springframework.lang.Nullable;

/*
 * @Nullable 注解可以使用
 *    - 在方法上面，表示方法返回可以为空
 *    - 在属性上面，属性值可以为空，
 *    - 在参数上面，参数值可以为空
 * */
public class NullableTest {

    @Nullable
    String c;

    @Nullable
    public String add(String a, @Nullable String b) {
        return a + " - " + b + " - " + c;
    }

}
