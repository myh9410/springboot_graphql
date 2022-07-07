package com.example.graphql.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_no")
    private Orders order;

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "item_no")
//    private Item item;

}
