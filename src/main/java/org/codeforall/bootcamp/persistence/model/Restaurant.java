package org.codeforall.bootcamp.persistence.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractModel{

    @OneToOne
    private Owner owner;

    @Column(name = "name", unique = true)
    private String name;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Restaurant that = (Restaurant) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + getId() + '\''+
                "owner=" + owner +
                ", name='" + name + '\'' +
                '}';
    }
}
