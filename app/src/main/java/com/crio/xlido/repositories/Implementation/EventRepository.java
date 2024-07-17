package com.crio.xlido.repositories.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.xlido.entities.Event;
import com.crio.xlido.repositories.IEventRepository;

public class EventRepository implements IEventRepository {

    private final Map<String, Event> eventMap;
    private Integer autoIncrement = 0;

    public EventRepository() {
        this.eventMap = new HashMap<>();
    }

    @Override
    public Event save(Event event) {
        if (event.getId() == null) {
            autoIncrement++;
            Event e = new Event(Integer.toString(autoIncrement), event.getOrganiserId(),
                    event.getEventName());
            eventMap.put(e.getId(), e);
            return e;
        }
        eventMap.put(event.getId(), event);
        return event;
    }

    @Override
    public List<Event> findAll() {
        return eventMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Event> findId(String id) {
        return Optional.ofNullable(eventMap.get(id));
    }

    @Override
    public Event delete(Event event) {
        // eventMap.entrySet().removeIf(m->m.getValue().equals(event));
        eventMap.remove(event.getId());
        return event;
    }

}
