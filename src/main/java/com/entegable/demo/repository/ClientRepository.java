package com.entegable.demo.repository;

import com.entegable.demo.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Clients,Long> {
    Optional<Clients> findByDocnumber(String docNumber);

    Optional<Clients> findById(Long id);

}
