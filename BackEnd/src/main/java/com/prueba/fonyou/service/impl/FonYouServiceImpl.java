package com.prueba.fonyou.service.impl;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import com.prueba.fonyou.dto.RequestDTO;
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

    /**
     * Constantes con las cadenas de mensaje para mostrar al usuario
     */
    public static final String EXAM_NOT_FOUND = "El examen con este id no existe";

    public static final String STUDENTS_NOT_FOUND = "No se encuentran estudiantes con la zona horaria indicada";
    public static final String ASSIGNMENT_NOT_FOUND = "No se encuentra la asignación indicada";


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
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public List<Exam> getExamList() {
        return examRepository.findAll();
    }

    @Override
    public List<Question> getQuestionList() {
        return questionRepository.findAll();
    }

    @Override
    public List<Assignment> getAssignmentList() {
        return assignmentRepository.findAll();
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
        try {
            Optional<Exam> exam = examRepository.findById(requestDTO.getIdExam());
            if (exam.isEmpty()) {
                throw new FonYouException(EXAM_NOT_FOUND);
            }
            List<Student> studentList = studentRepository.findByTimeZone(requestDTO.getTimeZone());
            studentList.forEach(student -> {
                Assignment assignment = Assignment.builder().exam(exam.get()).date(requestDTO.getDate()).timeZone(requestDTO.getTimeZone()).student(student).build();
                assignmentRepository.save(assignment);
            });
            return studentList.size();
        } catch (NoSuchElementException nse) {
            throw new FonYouException(STUDENTS_NOT_FOUND);
        }


    }

    public void recordAnswers(RequestDTO requestDTO) {
        Optional<Assignment> assignment = assignmentRepository.findById(requestDTO.getIdAnswer());
        if (assignment.isEmpty()) {
            throw new FonYouException(EXAM_NOT_FOUND);
        }
        assignment.get().setAnswers(requestDTO.getAnswers());
        assignmentRepository.save(assignment.get());
    }

    public Long rateExam(RequestDTO requestDTO) {
        AtomicReference<Long> score = new AtomicReference<>(0L);
        Optional<Assignment> assignment = assignmentRepository.findById(requestDTO.getIdAnswer());
        if (assignment.isEmpty()) {
            throw new FonYouException(ASSIGNMENT_NOT_FOUND);
        }
        assignment.get().getAnswers().forEach((k, v) -> {
            Question q = assignment.get().getExam().getQuestionList().stream().filter(question -> question.getIdQuestion() == k).findAny().orElse(null);
            if (q != null && q.getCorrect_response().equals(v)) {
                score.updateAndGet(v1 -> v1 + q.getScore());
            }
        });
        assignment.get().setScore(score.get());
        assignmentRepository.save(assignment.get());
        return score.get();
    }
}
