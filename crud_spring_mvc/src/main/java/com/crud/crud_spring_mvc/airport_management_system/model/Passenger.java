package com.crud.crud_spring_mvc.airport_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Sep-20
 */
@Data
@NoArgsConstructor
@Entity
//@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String phone;

    @ManyToOne(cascade = CascadeType.PERSIST)
  //  @JoinColumn(name = "address_id")
   Address address;

    @ManyToMany(mappedBy = "passengers",
            cascade = CascadeType.PERSIST)
    Set<Trip> trips;

    public Passenger(String name, String phone,Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
