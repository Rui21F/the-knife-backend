package org.codeforall.bootcamp.services;

import org.codeforall.bootcamp.persistence.dao.ReservationDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void cancelReservationById(Integer reservationId);

    Reservation getReservationById(Integer reservationId);

    void setDao(ReservationDao dao);

}
