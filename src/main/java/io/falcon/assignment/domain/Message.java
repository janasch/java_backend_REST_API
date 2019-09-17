package io.falcon.assignment.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.falcon.assignment.services.MessageService;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;


public class Message {

    private UUID messageId;

    @NotEmpty(message = "Content of the message is missing")
    private String content;

    //TODO: change Timestamp format
    @NotEmpty(message = "Timestamp of the message is missing")
    private Timestamp timestamp;

    private Integer palindromeLength;

    @JsonCreator
    public Message(@JsonProperty("content") String content,
                                @JsonProperty("timestamp") Timestamp timestamp) {
        this.content = content;
        this.timestamp = timestamp;
        this.palindromeLength = findPalindromeLength(content);
    }

    public Message(){ }

    public Message(String content){
        this.content = content;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.palindromeLength = findPalindromeLength(content);
    }




    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPalindromeLength() {
        return palindromeLength;
    }

    public void setPalindromeLength(String palindrome) {
        int palindromeLength = findPalindromeLength(palindrome);
        this.palindromeLength = palindromeLength;}


    public Integer findPalindromeLength(String content){
        return new MessageService(content).getLongestPalindromeLength();
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId);
    }

    /* Creates a messageId as unique identifier */
    @Override
    public int hashCode() {
        return Objects.hash(messageId);
    }
}



