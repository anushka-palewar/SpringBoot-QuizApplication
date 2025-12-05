package in.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
