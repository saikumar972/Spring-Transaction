package com.esrx.transaction.service;

import com.esrx.transaction.entity.Insurance;
import com.esrx.transaction.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class OrganizationService {
    @Autowired
    InsuranceService insuranceService;
    @Autowired
    StudentService studentService;
    @Transactional(propagation = Propagation.REQUIRED)
    public String onBoardStudentAndInsurance( Student student, Insurance insurance){
        System.out.println("Current Transaction Active/NotActive "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Current Transaction Name "+ TransactionSynchronizationManager.getCurrentTransactionName());
        Student s1=studentService.saveStudent(student);
        Insurance i1=insuranceService.saveInsurance(insurance);
        return s1.toString()+i1.toString();
    }
}
