package com.example.demo1;

import java.util.concurrent.Flow;

/*
  jdk9及以后版本：观察者模式
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Flow.Publisher<String> publisher = subscriber -> {
            subscriber.onNext("1"); // 1
            subscriber.onNext("2");
            subscriber.onError(new RuntimeException("出错")); // 2
            //  subscriber.onComplete();
        };


        publisher.subscribe(new Flow.Subscriber<>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.cancel();
            }

            @Override
            public void onNext(String item) {
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("出错");
            }

            @Override
            public void onComplete() {
                System.out.println("publish complete");
            }
        });
    }
}
