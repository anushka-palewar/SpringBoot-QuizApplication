package in.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer>{
	List<Question> findByCategory(String category);
}
