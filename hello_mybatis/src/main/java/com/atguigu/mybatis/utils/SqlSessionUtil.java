package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: SqlSessionUtil
 * Package: com.atguigu.mybatis.utils
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/10 - 16:16  16:16
 * @Version: v1.0
 */


public class SqlSessionUtil {

    public static SqlSession getSqlSession(String mybatisCoreXml) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            //获得核心配置文件的输入流
            is = Resources.getResourceAsStream(mybatisCoreXml);
            //获取 SqlSessionFactoryBuilder 对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //创建 SqlSessionFactory 工厂对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取 mybatis中操作数据库的核心对象 sqlSession 且设置为自动提交事务
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭输入流
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //获取Mybatis操作数据库的对象 SqlSession时设置自动提交事务
        return sqlSession;
    }

}
