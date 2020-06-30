package com.neusoft.backend.Controller;

import com.google.gson.Gson;
import com.neusoft.backend.Model.Teacher;
import com.neusoft.backend.Service.TeacherService;
import com.neusoft.backend.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tea")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @RequestMapping("/addTeacher")
    public CommonResult addTeacher(@RequestBody Teacher teacher) {
        int isInserted = teacherService.addTeacher(teacher);
        if(isInserted > 0){
            return CommonResult.success(true);
        }else{
            return CommonResult.validateFailed();
        }
    }

    @RequestMapping(value = "/checkTeacher",method = RequestMethod.POST)
    public CommonResult checkTeacher(@RequestBody Teacher teacher){
        System.out.println("checkTeacher");
        teacher =  teacherService.checkTeacher(teacher);
        if (teacher != null){
            return CommonResult.success(true);
        }else {
            return CommonResult.validateFailed();
        }
    }
    @RequestMapping("/updateTeacher")
    public CommonResult updateTeacher(@RequestBody Teacher teacher) {
        int isUpdate = teacherService.updateTeacher(teacher);
        if (isUpdate > 0){
            return CommonResult.success(true);
        }else {
            return CommonResult.validateFailed();
        }
    }

    @RequestMapping("/deleteTeacher")
    public CommonResult deleteTeacher(@RequestBody Teacher teacher) {
        int isDeleted = teacherService.deleteTeacher(teacher.getT_id());
        if (isDeleted > 0){
            return CommonResult.success(true);
        }else {
            return CommonResult.validateFailed();
        }
    }
    @RequestMapping("/getTeachers")
    public List<Teacher> getTeachers() {

        List<Teacher> teacherList = teacherService.getTeachers();
//        Gson gson = new Gson();
//        String jsondata = gson.toJson(teacherList);
        return teacherList;
    }

    @RequestMapping("/getTeacherByResearch")
    public List<Teacher> getTeacherByResearch(@RequestBody Teacher teacher) {

        List<Teacher> teacherList = teacherService.getTeacherByResearch(teacher);
//        Gson gson = new Gson();
//        String jsondata = gson.toJson(teacherList);
        return teacherList;
    }
}
