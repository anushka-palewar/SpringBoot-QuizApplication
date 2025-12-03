package in.main.service;

import in.main.entities.Question;

import java.util.List;

public interface QuestionService {
	
	public List<Question> getAllQuestions();

	public List<Question> getQuestionsByCategory(String Category);
	
}
