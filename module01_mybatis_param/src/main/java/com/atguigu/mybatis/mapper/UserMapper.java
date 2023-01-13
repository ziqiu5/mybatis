package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ClassName: UserMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/10 - 22:09  22:09
 * @Version: v1.0
 */


public interface UserMapper {

    User queryUserByUsername(String username);

    User checkLogin(String username, String password);

    User checkLoginByMap(Map<String, Object> map);

    int addUser(User user);

    User signInByParam(@Param("username") String username, @Param("password") String password);

    User queryUserByUsernameFromParam(@Param("username") String username);

    int deleteUserByParam(@Param("id") Integer id);

    int updateUserByParam(@Param("username") String username, @Param("password") String password, @Param("gender") String gender, @Param("id") Integer id);

    Integer count();

    String queryUsernameById(@Param("id") Integer id);

    List<User> list();

    Map<String, Object> queryUserByIdToMap(@Param("id") Integer id);

    /**方式一:
     * 当要获取的结果没有实体类相对应时 比如查询平均值、薪水、部门名称时 这时就需要将这个结果放在Map集合中了
     * 因为Map集合中的键是没有固定的属性的,有两种方式获取 一种时将获得的每条Map记录放在一个List集合当中(这种方式较常用)
     * @return 返回得到的查询到的所有记录集合
     */
    List<Map<String,Object>> queryByAllUsersToMap();

    /**方式二:
     * 使用 @MapKey("")注解的方式 其中的 value值为要查询结果的属性名
     * @return 返回包含记录数的Map集合 其中键为 value值即要查询结果的属性名
     *                                     值为 获取的查询到的每条记录
     */
    @MapKey("id")
    Map<String,Object> selectAllUsersToMap();




}
