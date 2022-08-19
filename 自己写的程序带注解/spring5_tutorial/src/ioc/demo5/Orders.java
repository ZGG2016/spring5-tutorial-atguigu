package ioc.demo5;


public class Orders {

    // 1. 创建类，定义属性，创建属性对应有参数构造方法
    private String orderName;
    private String orderAddress;

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public void getInfo(){
        System.out.println(this.orderName + " -- " +this.orderAddress);
    }
}
