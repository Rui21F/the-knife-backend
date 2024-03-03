package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.OwnerDto;
import org.codeforall.bootcamp.persistence.model.Owner;
import org.codeforall.bootcamp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerDtoToOwner extends AbstractConverter<OwnerDto, Owner> {

    private OwnerService ownerService;

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public Owner convert(OwnerDto ownerDto) {
        Owner owner = (ownerDto.getId() != null) ? ownerService.getOwnerById(ownerDto.getId()) : new Owner();
        owner.setName(ownerDto.getName());

        return owner;
    }
}
