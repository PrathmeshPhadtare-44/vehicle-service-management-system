package com.prathmesh.vsms.entity;

import com.prathmesh.vsms.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    private Long vehicleId;

    @Column(unique = true , nullable = false , length = 20)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(nullable = false , length = 100)
    private  String model;


    @ManyToOne
    @JoinColumn(name = "customerId" , nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "vehicle")
    private List<ServiceRecord> serviceRecord;

}
