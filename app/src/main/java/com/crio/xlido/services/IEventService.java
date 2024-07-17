package com.crio.xlido.services;

import com.crio.xlido.entities.Event;

public interface IEventService {

    public Event create(String eventName, String userId);

    public Event delete(String eventId, String userId);

}
