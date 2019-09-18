package io.falcon.assignment.persistence;

import io.falcon.assignment.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private MessageEntityRepository messageEntityRepository;

    @Override
    public Message add(Message message) {
        long messageId = messageEntityRepository.save(mapToEntity(message)).getMessageId();
        message.setId(messageId);
        return message;
    }

    @Override
    public void update(Message message) {
        messageEntityRepository.save(mapToEntity(message));
    }

    @Override
    public void remove(long messageId) {
        messageEntityRepository.deleteById(messageId);
    }

    @Override
    public Optional<Message> findById(long messageId) {
        return messageEntityRepository.findById(messageId).map(MessageRepositoryImpl::mapFromEntity);
    }

    @Override
    public List<Message> findAll() {
        return messageEntityRepository.findAll().stream().
                map(MessageRepositoryImpl::mapFromEntity).
                collect(Collectors.toList());
    }

    private static Message mapFromEntity(MessageEntity entity) {
        return new Message(
                entity.getMessageId(),
                entity.getContent(),
                entity.getTimestamp(),
                entity.getPalindromeLength());
    }

    private static MessageEntity mapToEntity(Message message) {
        return new MessageEntity(
                message.getId(),
                message.getContent(),
                message.getTimestamp(),
                message.getPalindromeLength());
    }
}
