package org.codeforall.bootcamp.persistence.dao.jpa;

import org.codeforall.bootcamp.persistence.dao.RestaurantDao;
import org.codeforall.bootcamp.persistence.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public class JpaRestaurantDao extends GenerecicJpaDAo<Restaurant> implements RestaurantDao {

    public JpaRestaurantDao(JpaSessionManager sm) {
        super(sm, Restaurant.class);
    }
}
