package com.entegable.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoice_details_id;
    private Integer amount;
    private Double price;

    private Invoice invoice;
    private Products products;

    public Invoice_details() {
    }

    public Integer getInvoice_details_id() {
        return invoice_details_id;
    }

    public void setInvoice_details_id(Integer invoice_details_id) {
        this.invoice_details_id = invoice_details_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
