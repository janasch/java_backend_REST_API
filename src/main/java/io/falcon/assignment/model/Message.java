package io.falcon.assignment.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.falcon.assignment.util.Palindrome;
import io.falcon.assignment.util.DateTimeHelper;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


public class Message {

    private long id;

    @NotEmpty(message = "Content of the message is missing")
    private String content;

    // TODO: Make sure that we get the timezone offset with us when we serialize to a string / JSON
    @NotEmpty(message = "Timestamp of the message is missing")
    private LocalDateTime timestamo;

    private Integer palindromeLength = null;


    public Message(String content){
        this.setContent(content);
        this.setTimestamp(LocalDateTime.now());
    }

    @JsonCreator
    public Message(@JsonProperty("content") String content,
                   @JsonProperty("timestamp") String timestamp) {
        this.setContent(content);
        this.setTimestamp(DateTimeHelper.fromMsgFormattedString(timestamp));
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.palindromeLength = null; // Invalidate the palindrome "cache" when the content change
    }


    public LocalDateTime getTimestamp() {
        return timestamo;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamo = timestamp;
    }

    public Integer getPalindromeLength() {
        if(this.palindromeLength == null){
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



