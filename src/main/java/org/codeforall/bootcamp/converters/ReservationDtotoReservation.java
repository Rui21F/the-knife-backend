package org.codeforall.bootcamp.converters;


import org.codeforall.bootcamp.command.ReservationDto;
import org.codeforall.bootcamp.persistence.model.Client;
import org.codeforall.bootcamp.persistence.model.Reservation;
import org.codeforall.bootcamp.persistence.model.Restaurant;
import org.codeforall.bootcamp.services.ClientService;
import org.codeforall.bootcamp.services.ReservationService;
import org.codeforall.bootcamp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ReservationDtotoReservation extends AbstractConverter<ReservationDto, Reservation> {

    private ReservationService reservationService;
    private ClientService clientService;
    private RestaurantService restaurantService;

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public Reservation convert(ReservationDto reservationDto) {

        Reservation reservation = (reservationDto.getId() == null) ? new Reservation() : reservationService.getReservationById(reservationDto.getId());

        Client client = clientService.getClientById(reservationDto.getClientId());
        reservation.setClient(client);

        Restaurant restaurant = restaurantService.getRestaurantById(reservationDto.getRestaurantId());
        reservation.setRestaurant(restaurant);

        reservation.setTimeslot(Timestamp.valueOf(reservationDto.getTimeslot()));

        return reservation;
    }
}
