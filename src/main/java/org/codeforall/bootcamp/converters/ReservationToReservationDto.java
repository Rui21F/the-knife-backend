package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.ReservationDto;
import org.codeforall.bootcamp.persistence.model.Reservation;

public class ReservationToReservationDto extends AbstractConverter<Reservation, ReservationDto> {

    @Override
    public ReservationDto convert(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId(reservation.getId());
        reservationDto.setClientId(reservation.getClient().getId());
        reservationDto.setRestaurantId(reservation.getRestaurant().getId());
        reservationDto.setTimeslot(reservation.getTimeslot().toString());

        return reservationDto;
    }
}
