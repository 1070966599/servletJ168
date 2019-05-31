package com.lovo.servlet.mybaits.dao;

import com.lovo.servlet.mybaits.entity.SysTeacher;

public interface ISysTeacherDao {
    /**
     * 保存教师
     * @param sysTeacher 教师对象
     * @return 受影响的行数
     */
    public int savaTeacher(SysTeacher sysTeacher);
}
