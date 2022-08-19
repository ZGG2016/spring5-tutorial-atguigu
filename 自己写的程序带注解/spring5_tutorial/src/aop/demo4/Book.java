package aop.demo4;

import org.springframework.stereotype.Component;

@Component
public class Book {
    public void add() {
        System.out.println("add.........");
    }
}
