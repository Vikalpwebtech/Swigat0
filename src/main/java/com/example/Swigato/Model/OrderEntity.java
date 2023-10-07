package com.example.Swigato.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data is used for getter setters and required attribute constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orderEntity")

public class OrderEntity {
    @Id
    int id;

    String orderId;

    int orderTotal;

    @CreationTimestamp
    Date ordertime;

    //child
    @ManyToOne
    @JoinColumn
    Customer customer;

    //child
    @ManyToOne
    @JoinColumn
    DelieveryPartner delieveryPartner;

    //parent
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<FoodItems> foodItems = new ArrayList<>();

    //child
    @ManyToOne
    @JoinColumn
    Restaurants restaurant;

    //child
    @ManyToOne
    @JoinColumn
    DelieveryPartner deliverypartner;

}
