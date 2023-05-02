package com.entegable.demo.controller;

import com.entegable.demo.exception.ElementAlreadyExistException;
import com.entegable.demo.models.Clients;
import com.entegable.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/client")
public class ClientsController{
    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/")
    public ResponseEntity<Clients> create(@RequestBody Clients clients) throws ElementAlreadyExistException {
        return new ResponseEntity<>(this.clientService.create(clients), HttpStatus.OK);

    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Clients> update(@RequestBody Clients clients, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.clientService.upDate(clients,id), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Clients> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);

    }
    @GetMapping(path = "/")
    public ResponseEntity<List<Clients>> FindAll(){
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);

    }

}
