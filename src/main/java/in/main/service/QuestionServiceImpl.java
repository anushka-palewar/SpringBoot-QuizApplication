package in.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.main.entities.Question;
import in.main.repository.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo questionRepo;
	
	 @Override
	 public ResponseEntity<List<Question>> getAllQuestions() {
	        try {
	            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	 }

	@Override
	public ResponseEntity<List<Question>> getQuestionsByCategory(String Category) {
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(Category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> addQuestion(Question question) {
		questionRepo.save(question);
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
	}

}
