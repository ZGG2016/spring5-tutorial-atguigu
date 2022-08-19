package com.zgg.demo3;

import com.zgg.demo3.controller.UserHandler;
import com.zgg.demo3.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    // 1 创建Router路由
    public RouterFunction<ServerResponse> routerFunction(){
        UserServiceImpl userService = new UserServiceImpl();
        UserHandler userHandler = new UserHandler(userService);
        // 设置路由
        return RouterFunctions
                .route(GET("/users/{id}").and(accept(APPLICATION_JSON)), userHandler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), userHandler::getAllUsers);
    }

    // 2 创建服务器完成适配
    public void createReactorServer(){
        // 路由和handler适配
        RouterFunction<ServerResponse> router = routerFunction();
        HttpHandler httpHandler = toHttpHandler(router);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        // 创建服务器
        HttpServer httpServer = HttpServer.create();
        // 使用adapter来处理对httpServer的请求 request -> httpServer -> adapter -> httpHandler -> router(url 匹配 userHandler方法)
        httpServer.handle(adapter).bindNow();
    }
}
