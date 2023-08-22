package com.prueba.fonyou.controller;

import com.prueba.fonyou.dto.RequestDTO;
import com.prueba.fonyou.entity.*;
import com.prueba.fonyou.service.FonYouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase encargada de mapear los endpoints REST de la app
 *
 * @author Jhon Lara
 */
@RestController
@RequestMapping(value = "/fonyou")
public class FonYouController {

    @Autowired
    private FonYouService fonYouService;

    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        try {
            fonYouService.createStudent(student);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (FonYouException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return fonYouService.getStudentList();
    }

    @PostMapping("/exam")
    public ResponseEntity<String> createExam(@RequestBody Exam exam) {
        try {
            fonYouService.createExam(exam);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (FonYouException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping("/exam")
    public List<Exam> getExamList() {
        return fonYouService.getExamList();
    }

    @PostMapping("/question")
    public ResponseEntity<String> createQuestion(@RequestBody Question question) {
        try {
            fonYouService.createQuestion(question);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (FonYouException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping("/question")
    public List<Question> getQuestionList() {
        return fonYouService.getQuestionList();
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignExamList(@RequestBody RequestDTO requestDTO) {
        try {
            Integer students = fonYouService.assignExam(requestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Se asignaron a " + students);
        } catch (FonYouException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping("/assign")
    public List<Assignment> getAssignmentList() {
        return fonYouService.getAssignmentList();
    }

    @PostMapping("/record-answers")
    public ResponseEntity<String> recordAnswers(@RequestBody RequestDTO requestDTO) {
        try {
            fonYouService.recordAnswers(requestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (FonYouException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @PostMapping("/rate-exam")
    public ResponseEntity<String> rateExam(@RequestBody RequestDTO requestDTO) {
        try {
            fonYouService.rateExam(requestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (FonYouException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }


}
