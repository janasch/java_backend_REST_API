package io.falcon.assignment.test;

import io.falcon.assignment.model.Message;
import io.falcon.assignment.persistence.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;


    @Test
    public void storeAndFindMessage() {
        Message m = new Message("hello");
        entityManager.persist(m);
        entityManager.flush();
        Message returned = messageRepository.findAll().get(0);

        assertEquals(returned.getId(), m.getId(), "Id of stored object shall persist");
        assertEquals(returned.getContent(), m.getContent(), "Id of stored object shall persist");
    }


}
