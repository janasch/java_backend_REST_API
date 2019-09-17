package io.falcon.assignment.persistence.entities;

import com.fasterxml.jackson.annotation.*;

import java.util.UUID;

public interface MessageEntityRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36, updatable = false, nullable = false)
    @JsonSubTypes.Type(type = "uuid-char")
    private UUID messageId;

    private String content;

    private int palindromeLength;
}
