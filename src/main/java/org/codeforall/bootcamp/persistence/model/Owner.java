package org.codeforall.bootcamp.persistence.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "owner")
public class Owner extends AbstractModel{

    private String name;
    @Transient
    @Column(name = "restaurant", unique = true)
    private Restaurant restaurant;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Owner owner = (Owner) object;
        return Objects.equals(getId(), owner.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + getId() + '\''+
                "name='" + name + '\'' +
                '}';
    }
}
