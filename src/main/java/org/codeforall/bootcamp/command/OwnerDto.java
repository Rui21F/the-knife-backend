package org.codeforall.bootcamp.command;

import org.codeforall.bootcamp.persistence.model.Restaurant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OwnerDto {

    private Integer id;

    @NotNull(message = "name is mandatory")
    @NotBlank(message = "name is mandatory")
    @Size(min=3, max=64)
    private String name;

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

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
