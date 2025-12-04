package in.main.service;

import in.main.entities.Question;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface QuestionService {
	
	 public ResponseEntity<List<Question>> getAllQuestions();

	public ResponseEntity<List<Question>> getQuestionsByCategory(String Category);

	public ResponseEntity<String> addQuestion(Question question);
	
}
