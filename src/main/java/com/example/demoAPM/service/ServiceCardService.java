package com.example.demoAPM.service;

import com.example.demoAPM.model.ServiceCard;
import com.example.demoAPM.repository.ServiceCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceCardService {

    @Autowired
    private ServiceCardRepository serviceCardRepository;

    // FETCHING ALL ServiceCard DATA
    public List<ServiceCard> getAPMNameServiceCardAPMID() {
        return serviceCardRepository.findAll();
    }

    public List<ServiceCard> getAPMNameServiceCardAPMID(String idAPM) {
        return serviceCardRepository.findByaPMNumber(idAPM);
    }

    public List<ServiceCard> getAPMNameServiceCardWorkerID(String idWorker) {
        return serviceCardRepository.findByPersonWork(idWorker);
    }

    // FETCHING ServiceCard BY ID
    public ServiceCard getServiceCardById(Long Id) {
        return serviceCardRepository.findById(Id).orElseThrow();
    }

    // ADD NEW ServiceCard
    public void addNewServiceCard(ServiceCard empObj) {
        serviceCardRepository.save(empObj);
    }

    // DELETING ServiceCard BY ID
    public void deleteServiceCardId(Long id) {
        serviceCardRepository.deleteById(id);
    }

    // UPDATING ServiceCard BY ID
    public void updateServiceCardById(ServiceCard Obj) {
        serviceCardRepository.save(Obj);
    }

}
