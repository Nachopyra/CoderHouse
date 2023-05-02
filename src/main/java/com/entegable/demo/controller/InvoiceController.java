package com.entegable.demo.controller;

import com.entegable.demo.exception.ElementAlreadyExistException;
import com.entegable.demo.models.BillingRequest;
import com.entegable.demo.models.Invoice;
import com.entegable.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/invoice")
public class InvoiceController{
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(path = "/")
    public ResponseEntity<Invoice> create(@RequestBody BillingRequest billingRequest) throws ElementAlreadyExistException {
        return new ResponseEntity<>(this.invoiceService.create(billingRequest), HttpStatus.OK);

    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.invoiceService.update(invoice, Math.toIntExact(id)), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.invoiceService.findById(Math.toIntExact(id)), HttpStatus.OK);

    }
    @GetMapping(path = "/")
    public ResponseEntity<List<Invoice>> FindAll(){
        return new ResponseEntity<>(this.invoiceService.FindAll(), HttpStatus.OK);

    }

}
