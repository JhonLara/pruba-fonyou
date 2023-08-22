package com.prueba.fonyou.repository;

import com.prueba.fonyou.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Clase que obtiene todas las capacidades JPA para la entidad producto
 * 
 * @author Jhon Lara
 *
 */
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
