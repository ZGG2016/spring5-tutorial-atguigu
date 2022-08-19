package ioc.demo10;

import java.util.List;

public class Student {

    private List<Course> lsts;

    public void setLsts(List<Course> lsts) {
        this.lsts = lsts;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lsts=" + lsts +
                '}';
    }
}
