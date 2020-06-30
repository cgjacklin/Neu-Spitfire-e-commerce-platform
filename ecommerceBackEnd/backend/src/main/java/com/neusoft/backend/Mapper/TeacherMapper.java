package com.neusoft.backend.Mapper;

import com.neusoft.backend.Model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    public Teacher checkTeacher(Teacher teacher);
    public int addTeacher(Teacher teacher);
    public int updateTeacher(Teacher teacher);
    public int deleteTeacher(String tid);
    public List<Teacher> getTeachers();
    public List<Teacher> getTeacherByResearch(Teacher teacher);
}
