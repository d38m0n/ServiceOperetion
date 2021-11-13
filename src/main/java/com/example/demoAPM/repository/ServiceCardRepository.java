package com.example.demoAPM.repository;

import com.example.demoAPM.model.ServiceCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCardRepository extends JpaRepository<ServiceCard, Long> {

    List<ServiceCard> findByaPMNumber(String aPMNumber);
    List<ServiceCard> findByPersonWork(String personID);
}
