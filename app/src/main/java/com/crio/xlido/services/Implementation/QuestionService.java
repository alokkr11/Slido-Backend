package com.crio.xlido.services.Implementation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.xlido.entities.Question;
import com.crio.xlido.exceptions.EventException;
import com.crio.xlido.exceptions.QuestionException;
import com.crio.xlido.exceptions.UserException;
import com.crio.xlido.repositories.IEventRepository;
import com.crio.xlido.repositories.IQuestionRepository;
import com.crio.xlido.repositories.IUserRepository;
import com.crio.xlido.services.IQuestionService;

public class QuestionService implements IQuestionService {

        private final IUserRepository userRepository;
        private final IEventRepository eventRepository;
        private final IQuestionRepository questionRepository;

        public QuestionService(IUserRepository userRepository, IEventRepository eventRepository,
                        IQuestionRepository questionRepository) {
                this.userRepository = userRepository;
                this.eventRepository = eventRepository;
                this.questionRepository = questionRepository;
        }

        @Override
        public Question add(String content, String userId, String eventId) {
                userRepository.findById(userId).orElseThrow(() -> new UserException(
                                "User with an id " + userId + " does not exist"));
                eventRepository.findId(eventId).orElseThrow(() -> new EventException(
                                "Event with an id " + eventId + " does not exist"));
                Question question = new Question(content, userId, eventId);
                return questionRepository.save(question);
        }

        @Override
        public Question delete(String id, String userId) {
                Question question = questionRepository.findById(id)
                                .orElseThrow(() -> new QuestionException(
                                                "Question with an id " + id + " does not exist"));
                userRepository.findById(userId).orElseThrow(() -> new UserException(
                                "User with an id " + userId + " does not exist"));

                if (!question.getUserId().equals(userId)) {
                        throw new UserException("User with an id " + userId
                                        + " is not an author of question with an id " + 2);
                }

                return questionRepository.delete(question);
        }

        @Override
        public Question upvote(String id, String userId) {
                Question question = questionRepository.findById(id)
                                .orElseThrow(() -> new QuestionException(
                                                "Question with an id " + id + " does not exist"));

                userRepository.findById(userId).orElseThrow(() -> new UserException(
                                "User with an id " + userId + " does not exist"));

                if (question.getUserVoted().contains(userId)) {
                        throw new UserException("User with an id " + userId
                                        + " has already upvoted a question with an id " + id);
                }

                Integer upvotes = question.getUpvotes();
                upvotes++;
                question.setUpvotes(upvotes);
                question.getUserVoted().add(userId);

                return questionRepository.save(question);
        }

        @Override
        public Question reply(String content, String id, String userId) {
                Question question = questionRepository.findById(id)
                                .orElseThrow(() -> new QuestionException(
                                                "Question with an id " + id + " does not exist"));

                userRepository.findById(userId).orElseThrow(() -> new UserException(
                                "User with an id " + userId + " does not exist"));

                question.getReplies().put(userId, content);
                return questionRepository.save(question);
        }

        @Override
        public List<Question> getAll(String eventId, String sortBy) {
                eventRepository.findId(eventId).orElseThrow(() -> new EventException(
                                "Event with an id " + eventId + " does not exist"));

                List<Question> qList = questionRepository.findAll();
                if (sortBy.equals("POPULAR")) {
                        qList = qList.stream().sorted((s1, s2) -> s2.getUpvotes() - s1.getUpvotes())
                                        .collect(Collectors.toList());
                        return qList;
                }

                Collections.reverse(qList);
                return qList;
        }



}
