package com.example.Swigato.Model;

import com.example.Swigato.Enum.Gender;
import jakarta.persistence.*;
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
@Table(name = "delieveryPartner")
public class DelieveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true,nullable = false)
    @Size(min = 10,max = 10)
    String mobileno;

    @Enumerated(EnumType.STRING)
    Gender gender;

    //Parent
    @OneToMany(mappedBy = "deliverypartner",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();

}
