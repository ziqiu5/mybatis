package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: SpecialSqlMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/12 - 16:43  16:43
 * @Version: v1.0
 */


public interface SpecialSqlMapper {

    List<User> queryByLikeForUsername(@Param("likeUsername") String likeUsername);

    Integer batchDeleteById(@Param("ids")String ids);


}
