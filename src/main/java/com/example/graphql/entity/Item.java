package com.example.graphql.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "item")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private int price;

//    @OneToMany(mappedBy = "item")
//    private List<OrderItems> orderItemsList;

}
