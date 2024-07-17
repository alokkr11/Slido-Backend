package com.crio.xlido.repositories;

import java.util.List;
import java.util.Optional;
import com.crio.xlido.entities.Event;

public interface IEventRepository {

    public Event save(Event event);

    public List<Event> findAll();

    public Optional<Event> findId(String id);

    public Event delete(Event event);

}
