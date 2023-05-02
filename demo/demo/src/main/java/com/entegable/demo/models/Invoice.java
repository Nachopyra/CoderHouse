package com.entegable.demo.models;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Date;
import java.util.List;

@Entity
public class Invoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // private Integer id_Cliente
    private Date created_at;
    private Double total;

   /*private Clients clients;

    @OneToMany(mappedBy = "invoice")
    private List<Invoice_details> invoice_details;*/
   public Invoice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
