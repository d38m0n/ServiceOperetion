package com.example.demoAPM.service;

import com.example.demoAPM.dto.ItemDTO;
import com.example.demoAPM.helper.CSVItemHelper;
import com.example.demoAPM.model.Item;
import com.example.demoAPM.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    // FETCHING ALL Item DATA
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<ItemDTO> getItemsDTO() {
        ModelMapper modelMapper = new ModelMapper();
        return Arrays.asList(modelMapper.map(itemRepository.findAll(), ItemDTO[].class));
    }

    // FETCHING Item BY ID
    public Item getItemById(Long empId) {
        return itemRepository.findById(empId).orElseThrow();
    }

    // ADD NEW Item
    public void addNewItem(Item empObj) {
        itemRepository.save(empObj);
    }

    // DELETING Item BY ID
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    // UPDATING Item BY ID
    public void updateItemById(Item employeeObj) {
        itemRepository.save(employeeObj);
    }

    //        CVS Save
    public void saveItems(MultipartFile file) {
        try {
            List<Item> item = CSVItemHelper.csvToItem(file.getInputStream());
            itemRepository.saveAll(item);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    //        CVS load
    public ByteArrayInputStream load() {
        List<Item> items = itemRepository.findAll();

        ByteArrayInputStream in = CSVItemHelper.tutorialsToCSV(items);
        return in;
    }

    //        CVS get all
    public List<Item> getAllTutorials() {
        return itemRepository.findAll();
    }

}
