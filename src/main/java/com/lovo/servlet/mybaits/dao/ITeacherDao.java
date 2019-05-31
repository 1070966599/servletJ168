package com.lovo.servlet.mybaits.dao;

import com.lovo.servlet.mybaits.entity.TeacherEntity;

import java.util.List;

/**
 * 教师持久层
 */
public interface ITeacherDao {

    public TeacherEntity getTeacherEntity(String userName,String password);

    public List<TeacherEntity> getListTeacher();

    public  long savaTeacher(TeacherEntity teacherEntity);
}
