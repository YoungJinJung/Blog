package com.project.blog.model;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
//ORM -> java
@Entity
public class User {
    @Id//Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//auto_increment

    @Column(nullable = false, length = 30)
    private String userName;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'usr'")
    private String role;//Enum

    @CreationTimestamp
    private Timestamp createDate;
}
