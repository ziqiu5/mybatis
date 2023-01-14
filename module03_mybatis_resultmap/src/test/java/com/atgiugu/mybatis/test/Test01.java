package com.atgiugu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName: Test01
 * Package: com.atgiugu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/13 - 15:45  15:45
 * @Version: v1.0
 */


public class Test01 {
    @Test
    public void testEmpMapper(){
        //获取 SqlSession 对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("myBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.queryEmpById(1);
        System.out.println(emp);
    }

    @Test
    public void testEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.queryEmpAndDeptById(2);
        System.out.println(emp);
    }

    @Test
    public void testEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.queryEmpAndDeptByStepOne(4);
        System.out.println("员工姓名：" + emp.getEmpName());
    }


}
