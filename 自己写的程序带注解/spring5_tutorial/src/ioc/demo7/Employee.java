package ioc.demo7;

public class Employee {
    private String empName;
    private String empGender;
    // 1. 创建 Department 类型属性，生成 set 方法
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empGender='" + empGender + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
