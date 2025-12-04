package in.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String Category,@RequestParam int noOfQue,@RequestParam String Title) {
		return new ResponseEntity<>("I am here",HttpStatus.OK);
	}
}
