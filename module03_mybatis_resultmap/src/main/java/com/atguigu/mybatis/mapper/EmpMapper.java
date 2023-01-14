package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: EmpMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/13 - 15:42  15:42
 * @Version: v1.0
 */


public interface EmpMapper {

    Emp queryEmpById(@Param("empId") Integer empId);


    Emp queryEmpAndDeptById(@Param("empId") Integer empId);

    Emp queryEmpAndDeptByStepOne(@Param("empId") Integer empId);

}
