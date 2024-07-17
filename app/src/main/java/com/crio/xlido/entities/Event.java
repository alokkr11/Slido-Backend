package com.crio.xlido.entities;

public class Event extends BaseEntity {
    private String organiserId;
    private String eventName;

    public Event(String organiserId, String eventName) {
        this.organiserId = organiserId;
        this.eventName = eventName;
    }

    public Event(String id, String organiserId, String eventName) {
        this.id = id;
        this.organiserId = organiserId;
        this.eventName = eventName;
    }

    public String getOrganiserId() {
        return organiserId;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
        result = prime * result + ((organiserId == null) ? 0 : organiserId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (eventName == null) {
            if (other.eventName != null)
                return false;
        } else if (!eventName.equals(other.eventName))
            return false;
        if (organiserId == null) {
            if (other.organiserId != null)
                return false;
        } else if (!organiserId.equals(other.organiserId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Event [eventName=" + eventName + ", organiserId=" + organiserId + "]";
    }

}
