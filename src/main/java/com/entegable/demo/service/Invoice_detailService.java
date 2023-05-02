package com.entegable.demo.service;

import com.entegable.demo.exception.ElementAlreadyExistException;
import com.entegable.demo.exception.ElementNotFoundException;
import com.entegable.demo.models.Invoice;
import com.entegable.demo.models.Invoice_detail;
import com.entegable.demo.repository.Invoice_detailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Invoice_detailService {
    @Autowired
    private Invoice_detailRepository invoice_detailRepository;


    public Invoice_detailService(Invoice_detailRepository invoice_detailRepository){

    }

    public Invoice_detail create(Invoice_detail newInvoice_detail) throws ElementAlreadyExistException {
        Optional<Invoice_detail> invoice_detailOp = this.invoice_detailRepository.findByCode(newInvoice_detail.getCode());
        if(invoice_detailOp.isPresent()){
            throw new ElementAlreadyExistException("El detalle de Factura que intenta agregar ya existe en la Base de Datos");
        }else {
            this.invoice_detailRepository.save(newInvoice_detail);
            return newInvoice_detail;
        }

    }
    public Invoice_detail update(Invoice_detail newInvoice_detail, Integer id) throws Exception {
        if (id <= 0) throw new Exception("El Id ingresado no es válido");

        Optional<Invoice_detail>  invoice_detailOp = this.invoice_detailRepository.findById(id);

        if(invoice_detailOp.isEmpty()){
            throw new ElementNotFoundException("El detalle de factura que intenta actualizar no existe en la Base de Datos");
        }else {
            Invoice_detail invoice_detailDb = invoice_detailOp.get();

            invoice_detailDb.setAmount(newInvoice_detail.getAmount());
            invoice_detailDb.setPrice(newInvoice_detail.getPrice());
            invoice_detailDb.setCode(newInvoice_detail.getCode());
            invoice_detailDb.setInvoice(newInvoice_detail.getInvoice());

            this.invoice_detailRepository.save(invoice_detailDb);
            return newInvoice_detail;
        }
    }
    public Invoice_detail findById(Integer id) throws Exception {
        if (id <= 0) {
            throw new Exception("El Id ingresado no es válido");
        }
        Optional<Invoice_detail> invoicedetailOp = this.invoice_detailRepository.findById(id);

        if(invoicedetailOp.isEmpty()) {
            throw new ElementNotFoundException("El detalle de la factura buscada por id no existe en la Base de Datos " + id);
        }
        return invoicedetailOp.get();

    }
    public List<Invoice_detail> findAll(){
        return this.invoice_detailRepository.findAll();
    }

}
