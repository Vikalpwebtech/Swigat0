package com.example.Swigato.Model;

import com.example.Swigato.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data is used for getter setters and required attribute constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//For Transformer
@Builder
@Table(name = "food_item")

public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String dishname;

    double price;

    @Enumerated(EnumType.STRING)
    FoodCategory foodCategory;

    //In app we usually hace button veg non-veg
    boolean veg;

    boolean available;

    //child
    @ManyToOne
    @JoinColumn
    Cart cart;

    //child
    @ManyToOne
    @JoinColumn
    OrderEntity order;

    //child
    @ManyToOne
    @JoinColumn
    Restaurants restaurant;

}
