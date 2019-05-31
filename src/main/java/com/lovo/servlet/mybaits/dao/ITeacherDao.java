package com.lovo.servlet.mybaits.dao;

import com.lovo.servlet.mybaits.entity.TeacherEntity;

import java.util.List;

/**
 * 教师持久层
 */
public interface ITeacherDao {

    public TeacherEntity getTeacherEntity(TeacherEntity teacherEntity);

    public List<TeacherEntity> getListTeacher();
}
