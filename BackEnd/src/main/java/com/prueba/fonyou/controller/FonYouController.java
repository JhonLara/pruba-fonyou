package com.prueba.fonyou.controller;

import java.util.List;

import com.prueba.fonyou.entity.*;
import com.prueba.fonyou.service.FonYouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase encargada de mapear los endpoints REST de la app
 * 
 * @author Jhon Lara
 *
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

	@PostMapping("/exam")
	public ResponseEntity<String> createExam(@RequestBody Exam exam) {
		try {
			fonYouService.createExam(exam);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (FonYouException exc) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
		}
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

	@PostMapping("/assign")
	public ResponseEntity<String> assignExamList(@RequestBody RequestDTO requestDTO) {
		try {
			Integer students = fonYouService.assignExam(requestDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Se asignaron a "+students);
		} catch (FonYouException exc) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
		}
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
