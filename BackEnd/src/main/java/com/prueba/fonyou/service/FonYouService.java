package com.prueba.fonyou.service;


import com.prueba.fonyou.entity.Assignment;
import com.prueba.fonyou.entity.Exam;
import com.prueba.fonyou.entity.Question;
import com.prueba.fonyou.dto.RequestDTO;
import com.prueba.fonyou.entity.Student;

import java.util.List;

/**
 * Clase encargada de declarar la estructura de las capacidades que se expondran
 * en la implementación del servicio
 *
 * @author Jhon Lara
 */
public interface FonYouService {

    void createStudent(Student student);

    void createExam(Exam exam);

    List<Student> getStudentList();

    List<Exam> getExamList();

    List<Question> getQuestionList();

    List<Assignment> getAssignmentList();

    void createQuestion(Question question);

    Integer assignExam(RequestDTO requestDTO);

    void recordAnswers(RequestDTO requestDTO);

    Long rateExam(RequestDTO requestDTO);


}
