package com.lovo.servlet.mybaits;

import com.lovo.servlet.mybaits.db.GetSession;
import com.lovo.servlet.mybaits.entity.TeacherEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TMybaits {

    @Test
    public  void findListTeacher(){
        //获得session
       SqlSession session= GetSession.creatSession();
       //SqlSession已经封装了CRUD,我们只需要调用它的方法
       List<TeacherEntity> list=    session.selectList("teacher.selectTeacher");
        for (TeacherEntity t:list) {
            System.out.printf(t.getTeacherName()+t.getTeacherClass());
        }
        session.close();
    }
}
