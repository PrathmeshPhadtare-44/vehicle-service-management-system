package com.prathmesh.vsms.entity;

import com.prathmesh.vsms.enums.ServiceStatus;
import com.prathmesh.vsms.enums.ServiceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class ServiceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long serviceRecordId;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;

    @Lob// Alternative ways length = 500 or columnDefinition = "TEXT"
    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Cost is required")
    @Positive(message = "Cost must be greater than 0")
    @Column(nullable = false)
    private BigDecimal cost;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceStatus serviceStatus;

    @ManyToOne
    @JoinColumn(name = "vehicleId" , nullable = false)
    private Vehicle vehicle;

}
