package ioc.demo11;

import java.util.List;


public class Student {

    private List<String> courseName;

    public void setCourseName(List<String> courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "courseName=" + courseName +
                '}';
    }
}
