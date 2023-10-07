package com.example.Swigato.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data is used for getter setters and required attribute constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//For Transformer
@Builder
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int cartTotal;

    //child
    @OneToOne
    @JoinColumn()
    Customer customer;

    //parent
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<FoodItems> foodItems = new ArrayList<>();

}
