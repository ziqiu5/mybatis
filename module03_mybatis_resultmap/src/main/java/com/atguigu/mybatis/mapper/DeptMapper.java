package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: DeptMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/13 - 23:19  23:19
 * @Version: v1.0
 */


public interface DeptMapper {

    Dept queryEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

}
