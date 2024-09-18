package com.order.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column (name = "item_name", nullable = false)
    private String itemName;

    @Column (name = "quantity", nullable = false)
    private Integer quantity;

    @Column (name = "price", nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn (name = "order_id", nullable = false)
    private Order orderId;

}
