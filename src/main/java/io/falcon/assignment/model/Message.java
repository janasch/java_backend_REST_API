package io.falcon.assignment.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.falcon.assignment.util.Palindrome;
import io.falcon.assignment.util.DateTimeHelper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "msg_content")
    private String content;

    // TODO: Make sure that we get the timezone offset with us when we serialize to a string / JSON
    @Column(name = "msg_timestamp")
    private LocalDateTime timestamp;

    @Column(name = "msg_palindromeLength")
    private int palindromeLength = 4;


    public Message(String content){
        this.setContent(content);
        this.setTimestamp(LocalDateTime.now());
        this.setPalindromeLength(getPalindromeLength());
    }

    public Message(){}

    @JsonCreator
    public Message(@JsonProperty("content") String content,
                   @JsonProperty("timestamp") String timestamp) {
        this.setContent(content);
        this.setTimestamp(DateTimeHelper.fromMsgFormattedString(timestamp));
        this.setPalindromeLength(getPalindromeLength());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.palindromeLength = -1; // Invalidate the palindrome "cache" when the content changes
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPalindromeLength() {
        if(this.palindromeLength == -1){
            int palindromeLength = Palindrome.calculatePalindrome(this.content);
            this.palindromeLength = palindromeLength;
            return palindromeLength;
        }else{
            return this.palindromeLength;
        }
    }

    public void setPalindromeLength(int palindromeLength) {
        this.palindromeLength = palindromeLength;
    }
}



