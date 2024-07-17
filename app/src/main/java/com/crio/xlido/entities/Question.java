package com.crio.xlido.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question extends BaseEntity {

    private String content;
    private String userId;
    private String eventId;
    private Integer upvotes;
    private Set<String> userVoted;
    private Map<String, String> replies;

    public Question(String id, String content, String userId, String eventId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.eventId = eventId;
        this.upvotes = 0;
        this.userVoted = new HashSet<>();
        this.replies = new HashMap<>();
    }

    public Question(String content, String userId, String eventId) {
        this.content = content;
        this.userId = userId;
        this.eventId = eventId;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public String getEventId() {
        return eventId;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public Set<String> getUserVoted() {
        return userVoted;
    }

    public Map<String, String> getReplies() {
        return replies;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public void setUserVoted(Set<String> userVoted) {
        this.userVoted = userVoted;
    }

    public void setReplies(Map<String, String> replies) {
        this.replies = replies;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
        result = prime * result + ((replies == null) ? 0 : replies.hashCode());
        result = prime * result + ((upvotes == null) ? 0 : upvotes.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userVoted == null) ? 0 : userVoted.hashCode());
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
        Question other = (Question) obj;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (eventId == null) {
            if (other.eventId != null)
                return false;
        } else if (!eventId.equals(other.eventId))
            return false;
        if (replies == null) {
            if (other.replies != null)
                return false;
        } else if (!replies.equals(other.replies))
            return false;
        if (upvotes == null) {
            if (other.upvotes != null)
                return false;
        } else if (!upvotes.equals(other.upvotes))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (userVoted == null) {
            if (other.userVoted != null)
                return false;
        } else if (!userVoted.equals(other.userVoted))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Question [content=" + content + ", eventId=" + eventId + ", replies=" + replies
                + ", upvotes=" + upvotes + ", userId=" + userId + ", userVoted=" + userVoted + "]";
    }

}
