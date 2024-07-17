package com.crio.xlido.repositories.Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.xlido.entities.Question;
import com.crio.xlido.repositories.IQuestionRepository;

public class QuestionRepository implements IQuestionRepository {

    private final Map<String, Question> questionMap;
    private Integer autoIncrement = 0;

    public QuestionRepository() {
        this.questionMap = new HashMap<>();
    }

    @Override
    public Question save(Question question) {
        if (question.getId() == null) {
            autoIncrement++;
            Question q = new Question(Integer.toString(autoIncrement), question.getContent(),
                    question.getUserId(), question.getEventId());
            questionMap.put(q.getId(), q);
            return q;
        }

        return questionMap.put(question.getId(), question);
    }

    @Override
    public Question delete(Question question) {
        questionMap.remove(question.getId());
        return question;
    }

    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questionMap.get(id));
    }

    @Override
    public List<Question> findAll() {
        return new ArrayList<>(questionMap.values());
    }

}
