package io.falcon.assignment.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import io.falcon.assignment.Application;
import io.falcon.assignment.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
;

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class MessageControllerIntegrTest {
        @Autowired
        private TestRestTemplate restTemplate;

        @LocalServerPort
        private int port;

        private String getRootUrl() {
            return "http://localhost:" + port;
        }


        /**
         * workaround: can for now only be tested locally, with the a test message  already in database on locahost,
         * and then response body can be inspected manually
         */
        @Test
        public void testMessageWord() {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/messages",
                    HttpMethod.GET, entity, String.class);
            System.out.println(response.getBody());
            assertNotNull(response.getBody());
        }







}
