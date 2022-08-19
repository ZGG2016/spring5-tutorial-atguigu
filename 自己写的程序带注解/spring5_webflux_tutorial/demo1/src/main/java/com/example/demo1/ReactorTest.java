package com.example.demo1;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorTest {
    public static void main(String[] args) {

        // just方法直接声明
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);

        //其他的方法
//        Integer[] array = {1,2,3,4};
//        Flux.fromArray(array);
//
//        List<Integer> list = Arrays.asList(array);
//        Flux.fromIterable(list);
//
//        Stream<Integer> stream = list.stream();
//        Flux.fromStream(stream);

    }
}
