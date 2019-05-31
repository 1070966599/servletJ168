package com.lovo.servlet.mybaits.dao;

import com.lovo.servlet.mybaits.dto.StudentAndTeacherDto;
import com.lovo.servlet.mybaits.entity.SysStudent;

import java.util.List;

public interface ISysStudentDao {
    /**
     * 添加学生
     * @param sysStudent 学生对象
     * @return 受影响的行数
     */
    public int savaStudent(SysStudent sysStudent);

    /**
     * 根据学生名字查询出学生对象
     * @param userName 学生名字
     * @return 学生对象
     */
    public SysStudent findStudentByName(String userName);

    /**
     * 根据学生查询出学生教师DTO
     *
     * @return  学生教师DTO
     */
    public List<StudentAndTeacherDto> findStudentAndTeacher();
}
