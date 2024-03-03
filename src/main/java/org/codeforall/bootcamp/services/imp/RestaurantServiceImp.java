package org.codeforall.bootcamp.services.imp;

import org.codeforall.bootcamp.persistence.dao.RestaurantDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Restaurant;
import org.codeforall.bootcamp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService {

    private RestaurantDao restaurantDao;

    @Transactional
    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantDao.saveOrUpdate(restaurant);
    }

    @Transactional
    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantDao.saveOrUpdate(restaurant);
    }

    @Transactional
    @Override
    public void deleteRestaurant(int restaurantId) {
            restaurantDao.delete(restaurantId);
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        return restaurantDao.findById(restaurantId);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantDao.findAll();
    }

    @Autowired
    public void setDao(RestaurantDao dao) {
        this.restaurantDao = dao;
    }

}