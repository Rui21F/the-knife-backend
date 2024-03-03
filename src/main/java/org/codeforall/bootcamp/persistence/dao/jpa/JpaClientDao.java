package org.codeforall.bootcamp.persistence.dao.jpa;

import org.codeforall.bootcamp.persistence.dao.ClientDao;
import org.codeforall.bootcamp.persistence.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class JpaClientDao extends GenerecicJpaDAo<Client> implements ClientDao {

    public JpaClientDao(JpaSessionManager sm) {
        super(sm, Client.class);
    }
}
