package ioc.demo11;

import java.util.List;

public class Book {
    private List<String> bookName;

    public void setBookName(List<String> bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName=" + bookName +
                '}';
    }
}
