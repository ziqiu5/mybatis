package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName: UserMapperTest
 * Package: com.atguigu.mybatis.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/10 - 15:47  15:47
 * @Version: v1.0
 */


public class UserMapperTest {
    @Test
    public void addUserTest() throws IOException {
        //获取 核心配置文件中的输入流
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        //获取 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取Mybatis操作数据库的对象 SqlSession(默认是未设置自动提交事务的 则会执行了语句后默认回滚)
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mybatis操作数据库的对象 SqlSession时设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行添加方法
        mapper.addUser();
        //提交事务
        sqlSession.commit();
        //关闭sqlSession会话
        sqlSession.close();
        //关闭输入流
        is.close();

    }

    @Test
    public void updateUserTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis.xml");
        //获取 UserMapper 的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testQueryUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById();
        System.out.println(user);
    }

    @Test
    public void testList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.list();
        list.forEach(System.out::println);
    }

}
