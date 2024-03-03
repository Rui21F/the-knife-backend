package org.codeforall.bootcamp.persistence.dao.jpa;

import org.codeforall.bootcamp.persistence.dao.OwnerDao;
import org.codeforall.bootcamp.persistence.model.Owner;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOwnerDao extends GenerecicJpaDAo<Owner> implements OwnerDao {

    public JpaOwnerDao(JpaSessionManager sm) {
        super(sm, Owner.class);
    }
}
