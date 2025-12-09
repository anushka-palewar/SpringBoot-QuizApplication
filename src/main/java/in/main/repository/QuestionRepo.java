package in.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.main.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :noOfQue",
           nativeQuery = true)
    List<Question> findRandomQuestionByCategory(
            @Param("category") String category,
            @Param("noOfQue") int noOfQue
    );
    
    List<Question> findBydifficultyLevel(String difficultyLevel);
}

