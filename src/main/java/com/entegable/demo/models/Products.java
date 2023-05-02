package com.entegable.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id")
    private Integer id;
    @Column(name = "description", length = 150)
    private String description;
    @Column(unique = true, name = "code", length = 50)
    private String code;
    private Integer stock;
    
    private Double price;

    /*@OneToMany(mappedBy = "products",cascade = CascadeType.ALL )
    private List<Invoice_detail> invoice_details;*/
    /*@ManyToOne
    @JoinColumn(name = "invoice_detail_id")
    private Invoice_detail invoice_detail;*/
    public Products() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /*public List<Invoice_detail> getInvoice_details() {
        return invoice_details;
    }

    public void setInvoice_details(List<Invoice_detail> invoice_details) {
        this.invoice_details = invoice_details;
    }*/
}
