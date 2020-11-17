package com.crud.crud_spring_mvc.airportManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Sep-20
 */

@Data
@NoArgsConstructor
@Entity
//@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
  //  @JoinColumn(name = "company_id")
    Company company;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime time_in;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime time_out;

    String city_from;
    String city_too;

    @ManyToMany
//    @JoinTable(name = "passenger_trips",
//            joinColumns = {@JoinColumn(name = "passenger_id")},
//            inverseJoinColumns = {@JoinColumn(name = "trip_id")})
    Set<Passenger> passengers;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", company=" + company +
                ", time_in=" + time_in +
                ", time_out=" + time_out +
                ", city_from='" + city_from + '\'' +
                ", city_too='" + city_too + '\'' +
                '}';
    }
}
