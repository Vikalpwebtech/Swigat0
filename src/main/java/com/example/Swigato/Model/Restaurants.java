package com.example.Swigato.Model;

import com.example.Swigato.Enum.RestaurantCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data is used for getter setters and required attribute constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "restaurants")
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String location;

    String restaurantid;

    RestaurantCategory restaurantCategory;

    @Column(unique = true,nullable = false)
    @Size(min = 10,max = 10)
    String contactno;

    boolean opened;

    //Parent
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();

    //Parent
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<FoodItems> foodItems = new ArrayList<>();
}
