package com.esrx.transaction.controller;

import com.esrx.transaction.entity.Insurance;
import com.esrx.transaction.entity.Student;
import com.esrx.transaction.entity.StudentInsurance;
import com.esrx.transaction.service.OrganizationService;
import com.esrx.transaction.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    public StudentService service;
    @Autowired
    OrganizationService organizationService;
    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @PostMapping("/saveBoth")
    public String save(@RequestBody StudentInsurance studentInsurance){
        return organizationService.onBoardStudentAndInsurance(studentInsurance.getStudent(),studentInsurance.getInsurance());
    }
    @GetMapping("/id/{id}")
    public Student findStudentById(@PathVariable int id){
        return service.getStudentByid(id);
    }
    @GetMapping("/name/{name}")
    public Student findStudentByName(@PathVariable String name){
        return service.getStudentByName(name);
    }
    @GetMapping("/dept/{dept}")
    public Student findStudentByDept(@PathVariable String dept){
        return service.getStudentByDept(dept);
    }
}
