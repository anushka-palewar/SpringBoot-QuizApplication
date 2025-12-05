package in.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.main.entities.Question;
import in.main.entities.QuestionWrapper;
import in.main.entities.Quiz;
import in.main.entities.Response;
import in.main.repository.QuestionRepo;
import in.main.repository.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public ResponseEntity<String> createQuiz(String category, int noOfQue, String title) {
		List<Question> que =questionRepo.findRandomQuestionByCategory(category,noOfQue);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQue(que);
		quizRepo.save(quiz);
		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
		Optional<Quiz> quiz=quizRepo.findById(id);
		List<Question> queFromDB=quiz.get().getQue();
		List<QuestionWrapper> queForUser= new ArrayList<>();
		
		for(Question q: queFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getQid(), q.getQuestionTitle(), q.getOption1(),  q.getOption2(),  q.getOption3(),  q.getOption4());
			queForUser.add(qw);
		}
		return new ResponseEntity<>(queForUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
	    Optional<Quiz> optionalQuiz = quizRepo.findById(id);
	    if (!optionalQuiz.isPresent()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    List<Question> questions = optionalQuiz.get().getQue();

	    Map<Integer, String> correctMap = questions.stream()
	            .collect(Collectors.toMap(Question::getQid, Question::getRightOption));

	    int right = 0;
	    for (Response r : responses) {
	        String correct = correctMap.get(r.getId());
	        if (correct != null && correct.equals(r.getResponse())) {
	            right++;
	        }
	    }

	    return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
