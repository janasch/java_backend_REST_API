package io.falcon.assignment.persistence;

import io.falcon.assignment.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    Message add(Message message);
    void update(Message message);
    void remove(long id);

    Optional<Message> findById(long id);
    List<Message> findAll();

}
