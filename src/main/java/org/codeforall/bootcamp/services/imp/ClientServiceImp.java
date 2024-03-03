package org.codeforall.bootcamp.services.imp;

import org.codeforall.bootcamp.persistence.dao.ClientDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Client;
import org.codeforall.bootcamp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
    private ClientDao clientDao;

    @Transactional
    @Override
    public Client createClient(Client client) {
        return clientDao.saveOrUpdate(client);
    }

    @Transactional
    @Override
    public Client updateClient(Client client) {
        return clientDao.saveOrUpdate(client);
    }

    @Transactional
    @Override
    public void deleteClient(int clientId) {
        clientDao.delete(clientId);
    }

    @Override
    public Client getClientById(int clientId) {
        return clientDao.findById(clientId);
    }

    @Override
    public List<Client> getAllClient() {
        return clientDao.findAll();
    }

    @Autowired
    @Override
    public void setDao(ClientDao dao) {
        this.clientDao = dao;
    }

}
