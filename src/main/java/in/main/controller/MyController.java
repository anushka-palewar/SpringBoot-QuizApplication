package in.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.main.entities.Question;
import in.main.service.QuestionService;

@RestController
public class MyController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/Category/{Category}")
	public List<Question> getQuestionsByCategory(@PathVariable String Category) {
		return questionService.getQuestionsByCategory(Category);
	}
}
