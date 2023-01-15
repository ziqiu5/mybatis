package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: TestPage
 * Package: com.atguigu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/15 - 14:48  14:48
 * @Version: v1.0
 */


public class TestPage {

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        //开启分页
        Page<Object> page = PageHelper.startPage(2, 4);

        List<Emp> emps = empMapper.selectByExample(null);

        //PageInfo导航分页: new PageInfo<>(emps, 5);
        //第一个参数:查询出的集合  第二个参数:要进行导航分页的页数
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
        emps.forEach(System.out::println);
    }
}
