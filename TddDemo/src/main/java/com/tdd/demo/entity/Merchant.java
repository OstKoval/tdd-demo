package com.tdd.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "merchant")
public class Merchant {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;
}
