package org.codeforall.bootcamp.converters;

import org.codeforall.bootcamp.command.ClientDto;
import org.codeforall.bootcamp.persistence.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDto extends AbstractConverter<Client, ClientDto> {

    @Override
    public ClientDto convert(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());

        return clientDto;
    }
}
