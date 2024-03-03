package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.RestaurantDto;
import org.codeforall.bootcamp.persistence.model.Restaurant;

public class RestaurantToRestaurantDto extends AbstractConverter<Restaurant, RestaurantDto> {

    @Override
    public RestaurantDto convert(Restaurant restaurant) {

        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());

        return restaurantDto;
    }
}
