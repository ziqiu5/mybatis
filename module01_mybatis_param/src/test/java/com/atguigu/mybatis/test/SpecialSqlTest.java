package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SpecialSqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: SpecialSqlTest
 * Package: com.atguigu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/12 - 17:15  17:15
 * @Version: v1.0
 */


public class SpecialSqlTest {
    @Test
    public void testQueryUsersByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        SpecialSqlMapper specialSqlMapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = specialSqlMapper.queryByLikeForUsername("a");
        list.forEach(System.out::println);
    }

    @Test
    public void testBatchDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        SpecialSqlMapper specialSqlMapper = sqlSession.getMapper(SpecialSqlMapper.class);
        Integer res = specialSqlMapper.batchDeleteById("11,12");
        System.out.println("res = " + res);
    }
}
