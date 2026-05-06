package tech.chillo.sa.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.chillo.sa.DTO.ClientInputDTO;
import tech.chillo.sa.DTO.ClientOutputDTO;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.exception.ClientCreateException;
import tech.chillo.sa.exception.ClientSearchException;
import tech.chillo.sa.repository.ClientRepository;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ClientService {
    final private ClientRepository clientRepository;

    public void creer( ClientInputDTO clientInputDTO ) {
        if (clientRepository.existsByEmail( clientInputDTO.email())) {
            throw new ClientCreateException ("Email existe déjà");
        }

       clientRepository.save(
                Client.builder()
                        .email( clientInputDTO.email())
                        .build()
        );
    }


    public ClientOutputDTO getById(Long id) {
        if(id == null) {
            throw new ClientSearchException ( "Id est null" );
        }
        Client clientTrouve = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientSearchException ("Client avec id " + id + " introuvable"));

        return ClientOutputDTO.builder ()
                .id(clientTrouve.getId())
                .email(clientTrouve.getEmail())
                .build();

    }


    public List <ClientOutputDTO> rechercher(){
        return this.clientRepository.findAll ().stream ()
                .map (
                Client -> ClientOutputDTO.builder ()
                        .id ( Client.getId () )
                        .email ( Client.getEmail () )
                        .build ()
        ).toList ();
    }

    public Client lireOuCreer(Client clientAcreer) {
        Client existing =this.clientRepository.findByEmail(clientAcreer.getEmail());

        if (existing == null) {
           existing = this.clientRepository.save(clientAcreer);

        }
        return existing;
    }

}
