package com.neusoft.backend.Service;

import com.neusoft.backend.Mapper.TeacherMapper;
import com.neusoft.backend.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeacherService {

    private TeacherMapper teacherMapper;

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper){
        this.teacherMapper = teacherMapper;
    }

    public int addTeacher(Teacher teacher){
        return teacherMapper.addTeacher(teacher);
    }

    public Teacher checkTeacher(Teacher teacher){
        return teacherMapper.checkTeacher(teacher);
    }
    public int updateTeacher(Teacher teacher){
        return teacherMapper.updateTeacher(teacher);
    }
    public int deleteTeacher(String tid){
        return teacherMapper.deleteTeacher(tid);
    }

    @Cacheable(cacheNames = "getTeachers")
    public List<Teacher> getTeachers(){
        return teacherMapper.getTeachers();
    }

    @Cacheable(cacheNames = "getTeachersByResearch")
    public List<Teacher> getTeacherByResearch(Teacher teacher){
        return teacherMapper.getTeacherByResearch(teacher);
    }



}
