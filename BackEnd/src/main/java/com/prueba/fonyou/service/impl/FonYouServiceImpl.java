package com.prueba.fonyou.service.impl;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import com.prueba.fonyou.entity.*;
import com.prueba.fonyou.repository.AssignmentRepository;
import com.prueba.fonyou.repository.ExamRepository;
import com.prueba.fonyou.repository.QuestionRepository;
import com.prueba.fonyou.repository.StudentRepository;
import com.prueba.fonyou.service.FonYouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Clase encargada de mapear y dar comportamiento a las capacidades de los
 * servicios
 *
 * @author Jhon Lara
 */
@Service
public class FonYouServiceImpl implements FonYouService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void createExam(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void createQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Integer assignExam(RequestDTO requestDTO) {

        List<Student> studentList = studentRepository.findByTimeZone(requestDTO.getTimeZone());

        studentList.forEach(student -> {
            Assignment assignment = Assignment.builder().exam(examRepository.findById(requestDTO.getIdExam()).get()).date(requestDTO.getDate()).timeZone(requestDTO.getTimeZone()).student(student).build();
            assignmentRepository.save(assignment);
        });


        return studentList.size();
    }

    public void recordAnswers(RequestDTO requestDTO) {
        Assignment assignment = assignmentRepository.findById(requestDTO.getIdAnswer()).get();
        assignment.setAnswers(requestDTO.getAnswers());
        assignmentRepository.save(assignment);
    }

    public Long rateExam(RequestDTO requestDTO) {
        AtomicReference<Long> score = new AtomicReference<>(0L);
        Assignment assignment = assignmentRepository.findById(requestDTO.getIdAnswer()).get();
        assignment.getAnswers().forEach((k, v) -> {
            Question q = assignment.getExam().getQuestionList().stream().filter(question -> question.getIdQuestion() == k).findAny().orElse(null);
            if (q != null && q.getCorrect_response().equals(v)) {
                score.updateAndGet(v1 -> v1 + q.getScore());
            }
        });
        assignment.setScore(score.get());
        assignmentRepository.save(assignment);

        return score.get();
    }
}
