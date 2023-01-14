package com.atguigu.mybatis.pojo;

/**
 * ClassName: Dept
 * Package: com.atguigu.mybatis.pojo
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/13 - 20:07  20:07
 * @Version: v1.0
 */


public class Dept {
    private Integer deptId;

    private String deptName;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
