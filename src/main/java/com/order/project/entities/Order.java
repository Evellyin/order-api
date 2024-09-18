package com.order.project.entities;

import com.order.project.enums.OrderStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn (name = "customer_id", nullable = false)
    private Customer customerId;

    @ManyToOne
    @JoinColumn (name = "restaurant_id", nullable = false)
    private Restaurant restaurantId;

    @Column (name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column (name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column (name = "status", nullable = false)
    @Enumerated (EnumType.STRING)
    private OrderStatus status;

}
