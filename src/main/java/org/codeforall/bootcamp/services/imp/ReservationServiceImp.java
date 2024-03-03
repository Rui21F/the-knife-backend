package org.codeforall.bootcamp.services.imp;

import org.codeforall.bootcamp.persistence.dao.ReservationDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Reservation;
import org.codeforall.bootcamp.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import java.util.List;

@Service
public class ReservationServiceImp implements ReservationService {

    private ReservationDao reservationDao;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationDao.saveOrUpdate(reservation);
    }


    @Transactional
    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationDao.saveOrUpdate(reservation);
    }

    @Transactional
    @Override
    public void cancelReservationById(Integer reservationId) {
        reservationDao.delete(reservationId);
    }

    @Override
    public Reservation getReservationById(Integer reservationId) {
        return reservationDao.findById(reservationId);
    }


    @Override
    @Autowired
    public void setDao(ReservationDao dao) {
        this.reservationDao = dao;
    }
}
