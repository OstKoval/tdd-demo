package com.tdd.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "merchant")
@Data
public class Merchant {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @ManyToOne
    private Agency agency;

}
