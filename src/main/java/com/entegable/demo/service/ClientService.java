package com.entegable.demo.service;

import com.entegable.demo.exception.ElementAlreadyExistException;
import com.entegable.demo.exception.ElementNotFoundException;
import com.entegable.demo.models.Clients;
import com.entegable.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){

    }
   public Clients create(Clients newClients) throws ElementAlreadyExistException {
        Optional<Clients> clientsOp = this.clientRepository.findByDocnumber(newClients.getDocnumber());
        if(clientsOp.isPresent()){
            throw new ElementAlreadyExistException ("El cliente que intenta agregar ya existe en la Base de Datos");
        }else {
            this.clientRepository.save(newClients);
            return newClients;
        }
    }
    public Clients upDate(Clients newClients, Long id) throws Exception {
        if (id <= 0){
            throw new Exception("El Id ingresado no es válido");
        }
        Optional<Clients> clientsOp = this.clientRepository.findById(id);

        if(clientsOp.isEmpty()){
            throw new ElementNotFoundException("El cliente que intenta actualizar no existe en la Base de Datos");
        }else {
            Clients clientsDb = clientsOp.get();
            clientsDb.setDocnumber(newClients.getDocnumber());
            clientsDb.setLastname(newClients.getLastname());
            clientsDb.setName(newClients.getName());
            /*clientsDb.setId(newClients.getId());*/


            //this.clientRepository.save(clientsDb);
            return clientsDb;
        }

    }
    public Clients findById(Long id)throws Exception {
        if (id <= 0) {
            throw new Exception("El Id ingresado no es válido");
        }
        Optional<Clients> clientsOp = this.clientRepository.findById(id);

        if(clientsOp.isEmpty()) {
            throw new ElementNotFoundException("El cliente buscado por id no existe en la Base de Datos " + id);
        }
        return clientsOp.get();
    }
    public List<Clients> findAll(){
        return this.clientRepository.findAll();
    }
   /* public Clients deleteById(){

    }*/
  /* ClientService getClientsByDocnumber(String docNumber){
        Clients clients =  clientRepository.findByDocnumber(docNumber);
        Clients clientService = new Clients();
        BeanUtils.copyProperties(clients,clientService);
        return clientService;

    }*/
}
