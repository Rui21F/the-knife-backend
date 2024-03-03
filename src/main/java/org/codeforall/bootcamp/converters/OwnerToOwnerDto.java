package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.OwnerDto;
import org.codeforall.bootcamp.persistence.model.Owner;

public class OwnerToOwnerDto extends AbstractConverter<Owner, OwnerDto> {

    @Override
    public OwnerDto convert(Owner owner) {

        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(owner.getId());
        ownerDto.setName(owner.getName());

        return ownerDto;
    }
}
