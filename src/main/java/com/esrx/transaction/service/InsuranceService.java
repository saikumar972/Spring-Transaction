package com.esrx.transaction.service;

import com.esrx.transaction.entity.Insurance;
import com.esrx.transaction.repo.InsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRepo insuranceRepo;


    @Transactional(propagation = Propagation.SUPPORTS)
    public Insurance saveInsurance(Insurance insurance){
        System.out.println("Current Transaction Active/NotActive "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Current Transaction Name "+ TransactionSynchronizationManager.getCurrentTransactionName());
        return insuranceRepo.save(insurance);
    }
    public Insurance getInsuranceById(int id){
        return insuranceRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    public Insurance getInsuranceByName(String name){
        return insuranceRepo.findByInsuranceName(name);
    }

}
