package org.codeforall.bootcamp.services.imp;

import org.codeforall.bootcamp.persistence.dao.OwnerDao;
import org.codeforall.bootcamp.persistence.model.Owner;
import org.codeforall.bootcamp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
public class OwnerServiceImp implements OwnerService {
    private OwnerDao ownerDao;


    @Transactional
    @Override
    public Owner createOwner(Owner owner) {
        return ownerDao.saveOrUpdate(owner);
    }

    @Transactional
    @Override
    public Owner updateOwner(Owner owner) {
        return ownerDao.saveOrUpdate(owner);
    }

    @Transactional
    @Override
    public void deleteOwner(int ownerId) {
        ownerDao.delete(ownerId);
    }

    @Override
    public Owner getOwnerById(int ownerId) {
        return ownerDao.findById(ownerId);
    }

    @Autowired
    public void setDao(OwnerDao dao) {
        this.ownerDao = dao;
    }

}
