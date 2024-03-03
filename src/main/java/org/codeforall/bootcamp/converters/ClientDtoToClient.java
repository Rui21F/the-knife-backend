package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.ClientDto;
import org.codeforall.bootcamp.persistence.model.Client;
import org.codeforall.bootcamp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoToClient implements Converter<ClientDto, Client> {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Client convert(ClientDto clientDto) {
        Client client = (clientDto.getId() != null) ? clientService.getClientById(clientDto.getId()) : new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());

        return client;

    }
}
