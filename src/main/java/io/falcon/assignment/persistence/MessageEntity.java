package io.falcon.assignment.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "messageID", length = 36, updatable = false, nullable = false)
    private long messageId;


    @Column(name = "content")
    private String content;


    @Column(name = "timestamp")
    private LocalDateTime timestamp;


    @Column(name = "pailindromelength")
    private int palindromeLength;


}

