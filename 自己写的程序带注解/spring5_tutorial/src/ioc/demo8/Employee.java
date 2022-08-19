package ioc.demo8;


public class Employee {
    private String empName;
    private String empGender;
    private Department department;

    // 1. 生成getter方法   （第二种写法）
    public Department getDepartment() {
        return this.department;
    }

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
