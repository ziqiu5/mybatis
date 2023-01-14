package com.atgiugu.mybatis.test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName: Test02
 * Package: com.atgiugu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/14 - 15:38  15:38
 * @Version: v1.0
 */


public class Test02 {

    @Test
    public void testQueryEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.queryDeptByDeptId(1);
        System.out.println(dept);
    }

    @Test
    public void testQueryDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.queryDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }

}
