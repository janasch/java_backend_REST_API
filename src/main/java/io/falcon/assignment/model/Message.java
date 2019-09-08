package io.falcon.assignment.model;


import javax.validation.constraints.NotEmpty;


public class Message {

    @NotEmpty(message = "Content of the message is missing")
    private String content;

    @NotEmpty(message = "Timestamp of the message is missing")
    private String timestamp;

    private Integer palindromeLength;


    public Message(){}


    public Message(String content, String timestamp){
        this.content = content;
        this.timestamp = timestamp;
    }




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPalindromeLength() {
        return palindromeLength;
    }

    public Integer setPalindromeLength(Integer palindromeLength) {
        return palindromeLength;
    }


}

