package com.oquendotest2.tutorialATL.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "last_name")
    private String last_name;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "tel")
    private String tel;

    @Getter @Setter @Column(name = "password")
    private String password;
}
