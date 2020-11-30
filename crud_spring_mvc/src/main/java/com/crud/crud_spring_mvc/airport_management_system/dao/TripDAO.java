package com.crud.crud_spring_mvc.airport_management_system.dao;


import com.crud.crud_spring_mvc.airport_management_system.model.Trip;

import java.util.List;
import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 17-Sep-20
 */
public interface TripDAO {
    Trip getById(int id);

    Set<Trip> getAll();

    Set<Trip> get(int page, int perPage, String sort);

    Trip save(Trip trip);

    Trip update(Trip trip);

    void delete(int tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);

}
