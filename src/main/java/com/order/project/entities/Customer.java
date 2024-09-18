package com.order.project.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "phone", nullable = false)
    private String phone;

    @Column (name = "address", nullable = false)
    private String address;

}
