package aop.demo4;

import org.springframework.stereotype.Component;

@Component
public class BookProxy {

    public void beforeAdd(){
        System.out.println("before..........");
    }

}
