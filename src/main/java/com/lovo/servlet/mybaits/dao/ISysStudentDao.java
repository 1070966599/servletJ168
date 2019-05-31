package com.lovo.servlet.mybaits.dao;

import com.lovo.servlet.mybaits.entity.SysStudent;

public interface ISysStudentDao {
    /**
     * 添加学生
     * @param sysStudent 学生对象
     * @return 受影响的行数
     */
    public int savaStudent(SysStudent sysStudent);
}
