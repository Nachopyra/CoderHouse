package com.entegable.demo.repository;

import com.entegable.demo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer>{
    Optional<Products> findByCode(String code);

    Products findById(Long id);

}
