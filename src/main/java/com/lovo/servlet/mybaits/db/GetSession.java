package com.lovo.servlet.mybaits.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获得mybaits的链接
 */
public class GetSession {


    private static SqlSessionFactory sqlSessionFactory; //工厂

    static {
        //配置文件，给mybaits的指令
        String resource="mybaitsConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用建造者设计模式创建了一个SqlSessionFactory.
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try {
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获得一个Session，链接
    public static SqlSession creatSession(){
       return sqlSessionFactory.openSession();
    }
}
