package com.sergio.ollamatest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MessageRequest {

    @Id
    private long id;

    @Column(nullable = false)
    private String prompt;

}
