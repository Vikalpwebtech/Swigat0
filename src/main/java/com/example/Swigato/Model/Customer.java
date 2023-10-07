package com.example.Swigato.Model;

import com.example.Swigato.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 40, message = "{validation.name.size.too_long}")
    String name;

    @Email
    @Column(unique = true)
    String email;

    String address;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    @Size(min = 10, max = 10)
    String phoneno;

    //Customer to Cart 1 to 1
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    //Customer to Order
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
}
