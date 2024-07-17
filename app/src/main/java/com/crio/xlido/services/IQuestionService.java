package com.crio.xlido.services;

import java.util.List;
import com.crio.xlido.entities.Question;

public interface IQuestionService {

    public Question add(String content, String userId, String eventId);

    public Question delete(String id, String userId);

    public Question upvote(String id, String userId);

    public Question reply(String content, String id, String userId);

    public List<Question> getAll(String eventId, String sortBy);

}
