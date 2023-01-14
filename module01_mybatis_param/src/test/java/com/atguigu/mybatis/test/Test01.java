package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Test01
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/10 - 22:15  22:15
 * @Version: v1.0
 */


public class Test01 {
    @Test
    public void testQueryByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByUsername("xiaolong");
        System.out.println(user);
    }

    @Test
    public void testCheckIn() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("ziqiu", "123");
        if (user != null) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "xiaomei");
        map.put("password", "798");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        //获取 SqlSession 对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        //获取 映射接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "huoRenDuoDuo", "799456", "男");
        userMapper.addUser(user);
        System.out.println(user);
    }


    @Test
    public void testSignIn() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.signInByParam("ziqiu", "123");
        System.out.println(user != null ? "登录成功!" : "登陆失败!");
    }


    @Test
    public void testQueryByUsernameFromParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByUsernameFromParam("ziqiu5");
        System.out.println("user = " + user);
        System.out.println(user != null ? "该用户名已存在!" : "用户可用！");
    }

    @Test
    public void testDeleteUserByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.deleteUserByParam(5);
        System.out.println(res > 0 ? "成功删除用户！" : "输入的用户id有误,执行删除失败！");
    }

    @Test
    public void testUpdateUserByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.updateUserByParam("ziqiu5", "7708801314520", "男", 8);
        System.out.println(res > 0 ? "成功修改用户！" : "输入的信息有误,修改失败！");
    }

    @Test
    public void testCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer count = userMapper.count();
        System.out.println("count = " + count);
    }

    @Test
    public void testQueryUsernameById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String username = userMapper.queryUsernameById(7);
        System.out.println(username != null ? "username : " + username : "不存在该用户id！");

    }


    @Test
    public void testQueryUsernameByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = userMapper.queryUserByIdToMap(3);
        System.out.println(map);
    }

    @Test
    public void testQueryAllUsersToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> list = userMapper.queryByAllUsersToMap();
        System.out.println(list);
    }

    @Test
    public void testSelectAllUsersToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = userMapper.selectAllUsersToMap();
        System.out.println(map);
    }

    @Test
    public void testList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("MyBatisConfig.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.list();
        list.forEach(System.out::println);
    }


}
