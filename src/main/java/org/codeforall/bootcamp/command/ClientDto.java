package org.codeforall.bootcamp.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class ClientDto {

    private Integer id;

    @NotNull(message = "name is mandatory")
    @NotBlank(message = "name is mandatory")
    @Size(min=3, max=64)
    private String name;

    @Email
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientDto clientDto = (ClientDto) object;
        return Objects.equals(id, clientDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
