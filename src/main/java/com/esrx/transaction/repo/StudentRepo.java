package com.esrx.transaction.repo;

import com.esrx.transaction.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findByName(String name);

    Student findByDept(String name);
}
