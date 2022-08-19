package ioc.demo3;

public class Orders {

    // 1. 创建类，定义属性，创建属性对应有参数构造方法
    private String orderName;
    private String orderAddress;

    // 有参数构造
    public Orders(String orderName, String orderAddress) {
        this.orderName = orderName;
        this.orderAddress = orderAddress;
    }

    public void getInfo(){
        System.out.println(this.orderName + " -- " +this.orderAddress);
    }
}
