package com.entegable.demo.repository;

import com.entegable.demo.models.Invoice;
import com.entegable.demo.models.Invoice_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Invoice_detailRepository extends JpaRepository<Invoice_detail,Integer> {
    Optional<Invoice_detail> findByCode(String code);
}
