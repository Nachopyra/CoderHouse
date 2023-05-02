package com.entegable.demo.repository;

import com.entegable.demo.models.Invoice;
import com.entegable.demo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer>{
    Optional<Invoice> findByCode(String code);

}

