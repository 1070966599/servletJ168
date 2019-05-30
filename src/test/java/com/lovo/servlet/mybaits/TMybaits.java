package com.lovo.servlet.mybaits;

import com.lovo.servlet.mybaits.db.GetSession;
import com.lovo.servlet.mybaits.entity.TeacherEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TMybaits {
    //获得session
    SqlSession session= null;
    @Before
    public  void before(){
        session= GetSession.creatSession();
    }
    @Test
    public  void findListTeacher(){

       //SqlSession已经封装了CRUD,我们只需要调用它的方法
       List<TeacherEntity> list=    session.selectList("teacher.selectTeacher2");
        for (TeacherEntity t:list) {
            System.out.printf(t.getTeacherName()+t.getTeacherClass());
        }

    }
    @Test
    public  void findTeacher(){

        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("陈");

      TeacherEntity t2=  session.selectOne("teacher.selectTeacher4",t);
        System.out.printf(t2.getTeacherName()+"/"+t2.getTeacherId());

    }
    @Test
    public  void countTeacher(){
     int num=   session.selectOne("teacher.countTeacher");
        System.out.printf(String.valueOf(num));
    }
    @Test
    public  void savaTeacher(){
        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("王老师");
        t.setTeacherClass("J170");
        session.update("teacher.savaTeacher",t);
        System.out.printf(t.getTeacherId()+"");
        session.commit();//提交事务
    }
    @Test
    public  void updateTeacher(){
        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("王老师2");
        t.setTeacherId(3);
        session.update("teacher.updateTeacher",t);
        session.commit();//提交事务
    }

    @Test
    public  void delTeacher(){
        TeacherEntity t=new TeacherEntity();

        t.setTeacherId(3);
        session.update("teacher.delTeacher",t);
        session.commit();//提交事务
    }
    @After
    public void after(){
        session.close();
    }
}
