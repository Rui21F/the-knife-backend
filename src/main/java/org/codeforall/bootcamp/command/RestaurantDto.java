package org.codeforall.bootcamp.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RestaurantDto {

    private Integer id;

    @NotNull(message = "name is mandatory")
    @NotBlank(message = "name is mandatory")
    @Size(min=3, max=64)
    private String name;

    @NotNull
    private Integer ownerId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "RestaurantDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
