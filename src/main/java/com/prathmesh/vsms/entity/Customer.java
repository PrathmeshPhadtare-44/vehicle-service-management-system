package com.prathmesh.vsms.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(unique = true , nullable = false , length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false , length = 100)
    private String name;

    @Column(nullable = false , length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String city;

    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles;
}
