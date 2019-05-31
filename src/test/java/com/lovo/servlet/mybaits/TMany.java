package com.lovo.servlet.mybaits;

import com.lovo.servlet.mybaits.dao.ISysStudentDao;
import com.lovo.servlet.mybaits.dao.ISysTeacherDao;
import com.lovo.servlet.mybaits.db.GetSession;
import com.lovo.servlet.mybaits.dto.StudentAndTeacherDto;
import com.lovo.servlet.mybaits.entity.SysStudent;
import com.lovo.servlet.mybaits.entity.SysTeacher;
import com.lovo.servlet.mybaits.util.GetUUID;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class TMany {

    ISysTeacherDao teacherDao;
    ISysStudentDao studentDao;
    SqlSession session=null;
    @Before
    public void before2(){
        session= GetSession.creatSession();
        teacherDao= session.getMapper(ISysTeacherDao.class);
        studentDao=session.getMapper(ISysStudentDao.class);
    }
    @Test
    public void savaTeacher(){
        SysTeacher t=new SysTeacher();

        t.setTId(GetUUID.createUUID());
        t.setTName("陈老师");
        t.setTClass(2);
        teacherDao.savaTeacher(t);

    }
@Test
    public void savaStudent(){
        SysTeacher t=new SysTeacher();
        t.setTId("b190e4b5681140859a2e5a0cd28fdecb");
    for(int i=0;i<10;i++) {
        SysStudent s = new SysStudent();
        s.setSId(GetUUID.createUUID());
        s.setSName("赵云"+i);
        s.setSScore(100);
        s.setSysTeacher(t);

        studentDao.savaStudent(s);
    }
    }
    @Test
    public void findStudentByName(){
     SysStudent student=   studentDao.findStudentByName("赵云");
      String str=  student.getSysTeacher().getTName();
        System.out.printf(str);
    }
    @Test
    public void findStudentAndTeacher(){
      StudentAndTeacherDto dto= studentDao.findStudentAndTeacher("赵云");
        System.out.printf(""+dto.getStudentName()+"/"+dto.getTeacherName());
    }

    @After
    public  void after(){
        session.commit();
        session.close();
    }
}
