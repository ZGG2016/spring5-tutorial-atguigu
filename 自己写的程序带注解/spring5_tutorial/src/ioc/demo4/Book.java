package ioc.demo4;


public class Book {

    // 1. 创建类，定义属性和对应的 set 方法
    private String bookName;
    private String bookAuthor;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void getInfo(){
        System.out.println(this.bookName + " -- " +this.bookAuthor);
    }
}
