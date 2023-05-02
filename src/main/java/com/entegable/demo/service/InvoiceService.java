package com.entegable.demo.service;

import com.entegable.demo.exception.ElementNotFoundException;
import com.entegable.demo.models.*;
import com.entegable.demo.repository.ClientRepository;
import com.entegable.demo.repository.InvoiceRepository;
import com.entegable.demo.repository.Invoice_detailRepository;
import com.entegable.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private Invoice_detailRepository invoiceDetailRepository;
    @Autowired
    private ProductsRepository productRepository;

    public InvoiceService(InvoiceRepository invoiceRepository){

    }
    public Invoice create(BillingRequest billingRequest){
            //Busco el Cliente en la BD
            Long clientId = billingRequest.getClientId();
            Optional<Clients> clients = clientRepository.findById(clientId);
            //Creo la Factura con fecha y añado el cliente
            Invoice invoice = new Invoice();
            invoice.setCreated_at(LocalDateTime.now().atZone(ZoneId.of("America/Buenos_Aires")).toLocalDateTime());
            invoice.setClients(clients);
            //Acumuladores
            Double invoiceTotal = Double.valueOf(0);
            List<Invoice_detail> invoice_details = new ArrayList<>();

            //Busco el producto pedido
            for (BillingDetail billingDetail : billingRequest.getBillingDetails()) {
                Long productId = billingDetail.getProductId();
                Products product = productRepository.findById(productId);

                // Creo el detalle de la factura
                Invoice_detail detail = new Invoice_detail();
                detail.setInvoice(invoice);
                detail.setAmount(billingDetail.getAmount());
                detail.setPrice(product.getPrice());
                detail.setProducts(product);
                detail.setSubtotal(detail.getPrice() * (detail.getAmount()));
                invoiceDetailRepository.save(detail);

                //Actualizo el Stock
                int newStock = product.getStock() - billingDetail.getAmount();
                product.setStock(newStock);
                productRepository.save(product);

                invoiceTotal = invoiceTotal + detail.getSubtotal();
                invoice_details.add(detail);
            }

            invoice.setTotal(invoiceTotal);
            invoice.setInvoice_details(invoice_details);

            return invoiceRepository.save(invoice);


    }

    public Invoice update(Invoice newInvoice, Integer id) throws Exception {
        if (id <= 0) throw new Exception("El Id ingresado no es válido");

        Optional<Invoice>  invoiceOp = this.invoiceRepository.findById(id);

        if(invoiceOp.isEmpty()){
            throw new ElementNotFoundException("La factura que intenta actualizar no existe en la Base de Datos");
        }else {
            Invoice invoiceDb = invoiceOp.get();

            invoiceDb.setCreated_at(newInvoice.getCreated_at());
            invoiceDb.setTotal(newInvoice.getTotal());
            invoiceDb.setId(newInvoice.getId());
            invoiceDb.setCode(newInvoice.getCode());
            invoiceDb.setClients(newInvoice.getClients());
            invoiceDb.setInvoice_details(newInvoice.getInvoice_details());


            this.invoiceRepository.save(invoiceDb);
        }
        return newInvoice;
    }
    public Invoice findById(Integer id) throws Exception {
        if (id <= 0) {
            throw new Exception("El Id ingresado no es válido");
        }
        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(id);

        if(invoiceOp.isEmpty()) {
            throw new ElementNotFoundException("La factura buscada por id no existe en la Base de Datos " + id);
        }
        return invoiceOp.get();
    }
    public List<Invoice> FindAll(){
        return this.invoiceRepository.findAll();
    }


}
