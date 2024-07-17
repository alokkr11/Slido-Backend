package com.crio.xlido.services.Implementation;

import com.crio.xlido.entities.Event;
import com.crio.xlido.entities.User;
import com.crio.xlido.exceptions.EventException;
import com.crio.xlido.exceptions.UserException;
import com.crio.xlido.repositories.IEventRepository;
import com.crio.xlido.repositories.IUserRepository;
import com.crio.xlido.services.IEventService;


public class EventService implements IEventService {

    private final IEventRepository eventRepository;
    private final IUserRepository userRepository;

    public EventService(IEventRepository eventRepository, IUserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Event create(String eventName, String userId) {
        User u = userRepository.findById(userId).orElseThrow(
                () -> new UserException("User with an id " + userId + " does not exist"));
        Event event = new Event(u.getId(), eventName);
        return eventRepository.save(event);
    }

    @Override
    public Event delete(String eventId, String userId) {
        Event e = eventRepository.findId(eventId).orElseThrow(
                () -> new EventException("Event with an id " + eventId + " does not exist"));
        userRepository.findById(userId).orElseThrow(
                () -> new UserException("User with an id " + userId + " does not exist"));
        if (!e.getOrganiserId().equals(userId)) {
            throw new EventException("User with an id " + userId
                    + " is not a organizer of Event with an id " + eventId);
        }
        eventRepository.delete(e);
        return e;
    }



}
