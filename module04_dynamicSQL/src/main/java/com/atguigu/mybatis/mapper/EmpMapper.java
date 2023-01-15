package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: EmpMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/14 - 19:45  19:45
 * @Version: v1.0
 */


public interface EmpMapper {

    int addEmp(@Param("emp") Emp emp);

    List<Emp> queryByCondition(Emp emp);

    List<Emp> queryEmpByChoose(Emp emp);

    int batchAddEmp(@Param("emps") List<Emp> emps);

    int batchDelete(@Param("ids") List<Integer> ids);

    List<Emp> list();

}
