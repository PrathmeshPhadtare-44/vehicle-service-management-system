package com.prathmesh.vsms.entity;

import com.prathmesh.vsms.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long vehicleId;

    @Column(unique = true , nullable = false , length = 20)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(nullable = false , length = 100)
    private  String model;


    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
