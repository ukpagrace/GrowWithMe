package com.example.GrowWithMe.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class User {

    @Id
    private Long id;
}
