package com.prueba.fonyou.service;


import com.prueba.fonyou.entity.Exam;
import com.prueba.fonyou.entity.Question;
import com.prueba.fonyou.entity.RequestDTO;
import com.prueba.fonyou.entity.Student;

/**
 * Clase encargada de declarar la estructura de las capacidades que se expondran
 * en la implementación del servicio
 * 
 * @author Jhon Lara
 *
 */
public interface FonYouService {

    void createStudent(Student student);

    void createExam(Exam exam);
    void createQuestion(Question question);

    Integer assignExam(RequestDTO requestDTO);

    void recordAnswers(RequestDTO requestDTO);

    Long rateExam(RequestDTO requestDTO);




}
