package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/10 - 15:24  15:24
 * @Version: v1.0
 */


public interface UserMapper {

    /**
     * 添加用户
     * @return 返回数据库受影响的行数
     */
    int addUser();

    /**
     * 根据用户id 修改用户信息
     */
    int updateUser();

    /**
     * 删除用户
     */
    int deleteUser();

    /**
     * 根据id 查询用户
     * @return 返回查询到的用户对象
     */
    User queryUserById();

    /**
     * 查询所有的用户信息
     * @return 返回查询到的所有用户信息集合
     */
    List<User> list();

}
