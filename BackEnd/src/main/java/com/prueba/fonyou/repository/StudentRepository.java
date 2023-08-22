package com.prueba.fonyou.repository;

import com.prueba.fonyou.entity.Student;
import com.prueba.fonyou.entity.TimeZoneEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByTimeZone(TimeZoneEnum timeZone);
}
