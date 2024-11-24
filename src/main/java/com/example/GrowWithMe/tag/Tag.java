package com.example.GrowWithMe.tag;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tag {

    @Id
    private Long id;
    private String name;
}
