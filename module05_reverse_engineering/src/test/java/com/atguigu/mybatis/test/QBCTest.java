package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: QBCTest
 * Package: com.atguigu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/15 - 10:46  10:46
 * @Version: v1.0
 */


public class QBCTest {
    
    @Test
    public void testQueryByQBC(){
        //获取MyBatis操作数据库的核心对象 SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample empExample = new EmpExample();
        // empExample.createCriteria() 创建条件对象
        empExample.createCriteria().andEmpNameEqualTo("ziqiu").andAgeGreaterThan(20);
        empExample.or().andGenderEqualTo("男");
        List<Emp> emps = empMapper.selectByExample(empExample);
        emps.forEach(System.out::println);
    }

}
