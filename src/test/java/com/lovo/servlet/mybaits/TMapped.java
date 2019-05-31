package com.lovo.servlet.mybaits;

import com.lovo.servlet.mybaits.dao.ITeacherDao;
import com.lovo.servlet.mybaits.db.GetSession;
import com.lovo.servlet.mybaits.entity.TeacherEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TMapped {

    @Test
    public  void getTeacher(){
        //获得session
      SqlSession session= GetSession.creatSession();
     // session.selectOne("命名空间+id",参数)；
      //得一个绑定好了的Dao
        ITeacherDao dao=   session.getMapper(ITeacherDao.class);
        //调用DAO的方法
        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("陈老师");
        t.setTeacherClass("J168");
//        long  t1=  dao.savaTeacher(t);
//        System.out.printf(""+t.getTeacherId());
//        session.commit();

      TeacherEntity te=dao.getTeacherEntity("陈老师","J168");
      System.out.printf(""+te.getTeacherId());
//      List<TeacherEntity> list= dao.getListTeacher();
//        System.out.printf(""+list.size());

    }
}
