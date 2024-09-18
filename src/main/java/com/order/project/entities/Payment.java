package com.order.project.entities;

import com.order.project.enums.PaymentMethodType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn (name = "order_id", nullable = false)
    private Order orderId;

    @Column (name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Enumerated
    @Column (name = "payment_method", nullable = false)
    private PaymentMethodType paymentMethod;

    @Column (name = "amount", nullable = false)
    private Float amount;

}
