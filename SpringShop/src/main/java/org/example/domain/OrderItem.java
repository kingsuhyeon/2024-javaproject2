package org.example.domain;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column
    private Long itemId;
    @Column
    private Double orderPrice;
    @Column
    private int count;
}
