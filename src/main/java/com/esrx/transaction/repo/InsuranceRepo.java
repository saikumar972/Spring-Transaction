package com.esrx.transaction.repo;

import com.esrx.transaction.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance, Integer> {
    Insurance findByInsuranceName(String name);
}
