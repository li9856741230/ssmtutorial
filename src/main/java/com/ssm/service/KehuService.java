package com.ssm.service;

import com.ssm.mapper.TeacherMapper;
import com.ssm.mapper.KehuMapper;
import com.ssm.model.Kehu;
import com.ssm.model.ResponseData;
import com.ssm.model.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yang on 06/04/2017.
 */
@Controller
@RequestMapping("/teacher")
public class KehuService {

    private static ApplicationContext ctx;
    private static KehuMapper kehuMapper;
    private static TeacherMapper teacherMapper;

    static {

        // spring-mybatis
        try {
            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
            kehuMapper = (KehuMapper) ctx.getBean("kehuMapper");
            teacherMapper = (TeacherMapper) ctx.getBean("teacherMapper");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    public @ResponseBody TeacherMapper (@PathVariable int id) {
//
//        Kehu kehu = kehuMapper.selectKehuByID(id);
//        return kehu;
//    }

    @RequestMapping("/kehu")
    public @ResponseBody List<Kehu> getAllKehu() {
        System.out.println("1111111111111111111111111111111111111111111111111111111111");
        List<Kehu> kehus = kehuMapper.selectKehus();
        System.out.println(kehus);
        return kehus;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Teacher> getAllTeacher() {

        List<Teacher> kehus = teacherMapper.selectTeachers();
        System.out.println(kehus);
        return kehus;
    }

   @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
   ResponseData addKehu(@RequestBody Kehu kehu) {

        ResponseData responseData = new ResponseData();
        kehuMapper.addKehu(kehu);
        responseData.setSuccess(true);
        return responseData;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateKehu(@RequestBody Kehu kehu, @PathVariable String id) {

        ResponseData responseData = new ResponseData();
        Kehu kehuForUpdate = kehuMapper.selectKehuByID(id);
        kehuForUpdate.setCcity(kehu.getCcity());
        kehuForUpdate.setCdianhua(kehu.getCdianhua());
        kehuForUpdate.setCjiedao(kehu.getCjiedao());
        kehuForUpdate.setCquxian(kehu.getCquxian());
        kehuForUpdate.setClianxiren(kehu.getClianxiren());
        kehuForUpdate.setClocation(kehu.getClocation());
        kehuForUpdate.setCname(kehu.getCname());
        kehuForUpdate.setCprovince(kehu.getCprovince());
        // to finish all setter...
        kehuMapper.updateKehu(kehuForUpdate);

        responseData.setSuccess(true);
        return responseData;
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public @ResponseBody ResponseData deleteTeacher(@PathVariable int id) {
//
//        ResponseData responseData = new ResponseData();
//        teacherMapper.deleteTeacher(id);
//
//        responseData.setSuccess(true);
//        return responseData;
//    }

}
