package org.codeforall.bootcamp.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ReservationDto {

    private Integer id;

    @NotNull
    private Integer clientId;

    @NotNull
    private Integer restaurantId;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")
    @Size(min = 20, max=20)
    private String timeslot;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) { //needs to be 2023-02-01 20:00:00
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", restaurantId=" + restaurantId +
                ", timestamp=" + timeslot +
                '}';
    }
}
