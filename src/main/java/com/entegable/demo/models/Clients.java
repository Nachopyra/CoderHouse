package com.entegable.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @Column(name = "name", length = 75)
    private String name;
    @Column(name = "lastname", length = 75)
    private String lastname;
    @Column(unique = true, name = "docnumber", length = 11)
    private String docnumber;

   /*@OneToMany(mappedBy = "Clients")
   @JsonBackReference
   private List<Invoice> invoice = new ArrayList<>();*/


   public Clients() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }
}
