package org.codeforall.bootcamp.services;

import org.codeforall.bootcamp.persistence.dao.OwnerDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Owner;

public interface OwnerService {

    Owner createOwner(Owner owner);

    Owner updateOwner (Owner owner);

    void deleteOwner (int ownerId);

    Owner getOwnerById (int ownerId);

    void setDao(OwnerDao dao);

}
