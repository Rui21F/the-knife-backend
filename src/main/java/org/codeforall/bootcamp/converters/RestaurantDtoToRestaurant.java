package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.RestaurantDto;
import org.codeforall.bootcamp.persistence.model.Restaurant;
import org.codeforall.bootcamp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDtoToRestaurant extends AbstractConverter<RestaurantDto, Restaurant> {

    private RestaurantService restaurantService;

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public Restaurant convert(RestaurantDto restaurantDto) {

        Restaurant restaurant = (restaurantDto.getId() == null) ? new Restaurant() : restaurantService.getRestaurantById(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());

        return restaurant;
    }
}
