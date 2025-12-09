package in.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import in.main.entities.QuestionWrapper;
import in.main.entities.Response;

public interface QuizService {

	ResponseEntity<String> createQuiz(String category, int noOfQue, String title);

	ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id);

	ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);

}
