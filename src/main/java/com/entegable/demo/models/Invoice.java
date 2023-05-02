package com.entegable.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("invoice_id")
    private Integer id;

    private String code;
    @Column(name = "created_at", nullable = false)
    @JsonProperty("created_at")
    private LocalDateTime created_at;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients Clients;
    @OneToMany(mappedBy = "invoice",fetch = FetchType.EAGER) /*cascade = CascadeType.ALL )*/
    @JsonProperty("invoice_detail")
    private List<Invoice_detail> invoice_details;


    public Invoice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Clients getClients() {
        return Clients;
    }

    public void setClients(com.entegable.demo.models.Clients clients) {
        Clients = clients;
    }

    public List<Invoice_detail> getInvoice_details() {
        return invoice_details;
    }

    public void setInvoice_details(List<Invoice_detail> invoice_details) {
        this.invoice_details = invoice_details;
    }


    public void setClients(Optional<com.entegable.demo.models.Clients> clients) {
    }
}