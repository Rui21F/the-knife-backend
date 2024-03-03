package org.codeforall.bootcamp.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractModel{

    @ManyToOne
    private Client client;

    @ManyToOne
    private Restaurant restaurant;

    @Column(name = "time_slot")
    private Timestamp timeslot;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Timestamp getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timestamp timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Reservation that = (Reservation) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + getId() + '\''+
                "client=" + client +
                ", restaurant=" + restaurant +
                ", timeslot=" + timeslot +
                '}';
    }
}
