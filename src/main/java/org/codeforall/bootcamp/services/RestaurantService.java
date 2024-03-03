package org.codeforall.bootcamp.services;

import org.codeforall.bootcamp.persistence.dao.ReservationDao;
import org.codeforall.bootcamp.persistence.dao.RestaurantDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Reservation;
import org.codeforall.bootcamp.persistence.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant createRestaurant (Restaurant restaurant);

    Restaurant updateRestaurant (Restaurant restaurant);

    void deleteRestaurant (int restaurantId);

    Restaurant getRestaurantById (int restaurantId);

    List<Restaurant> getAllRestaurant();

    void setDao(RestaurantDao dao);

}
