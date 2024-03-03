package org.codeforall.bootcamp.persistence.dao.jpa;

import org.codeforall.bootcamp.persistence.dao.ClientDao;
import org.codeforall.bootcamp.persistence.dao.Dao;
import org.codeforall.bootcamp.persistence.dao.ReservationDao;
import org.codeforall.bootcamp.persistence.model.Client;
import org.codeforall.bootcamp.persistence.model.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JpaReservationDao extends GenerecicJpaDAo<Reservation> implements ReservationDao {

    private JpaClientDao clientDao;

    public JpaReservationDao(JpaSessionManager sm) {
        super(sm, Reservation.class);
    }

    public void setDao(JpaClientDao dao) {
        this.clientDao = dao;
    }

    public List<Reservation> getReservesByClientId(Integer id){
        EntityManager em = sm.getCurrentSession();

        return em.find(Client.class, id).getReservationList();
    }
}
