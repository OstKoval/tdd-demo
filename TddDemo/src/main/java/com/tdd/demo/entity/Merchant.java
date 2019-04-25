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

    @Column(name = "name")
    private String name;

    @Column(name = "merchant_id")
    private String merchantID;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "website")
    private String website;

    @Column(name = "group")
    private String group;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "main_phone_number")
    private String mainPhoneNumber;

    @ManyToOne
    private Agency agency;

}
