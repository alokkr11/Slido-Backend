package com.crio.xlido.repositories;

import java.util.List;
import java.util.Optional;
import com.crio.xlido.entities.Question;

public interface IQuestionRepository {

    public Question save(Question question);

    public Question delete(Question question);

    public Optional<Question> findById(String id);

    public List<Question> findAll();

}
