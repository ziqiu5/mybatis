package com.atguigu.mybatis.pojo;

import java.io.Serializable;

/**
 * ClassName: Emp
 * Package: com.atguigu.mybatis.pojo
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/14 - 19:42  19:42
 * @Version: v1.0
 */


//开启二级缓存的条件之一: 实现可串行化接口
public class Emp implements Serializable {
    private Integer empId;

    private String empName;

    private Integer age;

    private String gender;

    public Emp(Integer empId, String empName, Integer age, String gender) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public Emp() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
