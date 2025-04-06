package com.esrx.transaction.service;

import com.esrx.transaction.entity.Student;
import com.esrx.transaction.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Student saveStudent(Student student){
        System.out.println("Current Transaction Active/NotActive "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Current Transaction Name "+ TransactionSynchronizationManager.getCurrentTransactionName());
        return studentRepo.save(student);
    }
    public Student getStudentByid(int id){
        return studentRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    public Student getStudentByName(String name){
        return studentRepo.findByName(name);
    }
    public Student getStudentByDept(String name){
        return studentRepo.findByDept(name);
    }
}
