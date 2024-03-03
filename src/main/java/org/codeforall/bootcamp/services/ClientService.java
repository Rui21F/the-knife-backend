package org.codeforall.bootcamp.services;

import org.codeforall.bootcamp.persistence.dao.ClientDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Client;

import java.util.List;

public interface ClientService {

    Client createClient (Client client);

    Client updateClient (Client client);

    void deleteClient(int ClientId);

    Client getClientById(int clientId);

    List<Client> getAllClient();

    void setDao(ClientDao dao);

}
