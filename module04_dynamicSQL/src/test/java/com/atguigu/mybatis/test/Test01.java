package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Test01
 * Package: com.atguigu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/14 - 19:51  19:51
 * @Version: v1.0
 */


public class Test01 {

    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.queryByCondition(new Emp(null, "ziqiu", 21, "男"));
        emps.forEach(System.out::println);
        //关闭 SqlSession 对象，避免资源的浪费
        sqlSession.close();
    }

    @Test
    public void testQueryEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.queryEmpByChoose(new Emp(null, "", 21, "男"));
        emps.forEach(System.out::println);
        //关闭 SqlSession 对象，避免资源的浪费
        sqlSession.close();
    }

    @Test
    public void testBatchAddEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp(null, "小小1", 23, "男");
        Emp emp2 = new Emp(null, "小小2", 22, "男");
        Emp emp3 = new Emp(null, "小小3", 24, "男");
        int res = empMapper.batchAddEmp(Arrays.asList(emp1, emp2, emp3));
        System.out.println(res > 0 ? "执行批量添加成功" : "执行失败！");
        //关闭 SqlSession 对象，避免资源的浪费
        sqlSession.close();
    }

    @Test
    public void testAddEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int res = empMapper.addEmp(new Emp(null, "小牛", 27, "男"));
        System.out.println(res > 0 ? "添加成功" : "添加失败");
        //关闭 SqlSession 对象，避免资源的浪费
        sqlSession.close();
    }

    @Test
    public void testBatchDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        empMapper.batchDelete(Arrays.asList(6,7,8));
        //关闭 SqlSession 对象，避免资源的浪费
        sqlSession.close();
    }
    
    @Test
    public void testSecondLevelCache() throws IOException {
        //获取 MyBatis 的核心配置文件流
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        //通过SqlSessionFactory中的build方法 创建 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmpMapper empMapper1 = sqlSession1.getMapper(EmpMapper.class);
        List<Emp> list1 = empMapper1.list();
        list1.forEach(System.out::println);
        sqlSession1.close();//关闭sqlSession1对象,开启二级缓存

        System.out.println("======================");

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmpMapper empMapper2 = sqlSession2.getMapper(EmpMapper.class);
        List<Emp> list2 = empMapper2.list();
        list2.forEach(System.out::println);


    }


}
