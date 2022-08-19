package ioc.demo14;

public class Orders {
    private String orderName;

    public Orders() {
        System.out.println("第一步：通过无参数构造器创建 bean 实例");
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
        System.out.println("第二步：为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）");
    }

    public void init(){
        System.out.println("第三步：调用 bean 的初始化的方法（需要进行配置初始化的方法）");
    }

    public void destroy(){
        System.out.println("第五步：当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）");
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderName='" + orderName + '\'' +
                '}';
    }
}
