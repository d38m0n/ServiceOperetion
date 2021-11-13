package com.example.demoAPM.controllerREST;

import com.example.demoAPM.dto.ItemDTO;
import com.example.demoAPM.helper.CSVItemHelper;
import com.example.demoAPM.model.Item;
import com.example.demoAPM.response.ResponseMessage;
import com.example.demoAPM.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class ItemControllerREST {

    @Autowired
    ItemService itemService;
    ResponseEntity ERROR = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error"));
    ResponseEntity SUCCESS = ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Success"));



    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVItemHelper.hasCSVFormat(file)) {
            try {
                itemService.saveItems(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();

                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/item/csv/download/")
                        .path(file.getOriginalFilename())
                        .toUriString();

                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, fileDownloadUri));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, ""));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message, ""));
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        InputStreamResource file = new InputStreamResource(itemService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    //      GET ALL JSON
    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        try {
            List<Item> itemList = itemService.getAllTutorials();

            if (itemList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Arrays.asList(modelMapper.map(itemList, ItemDTO[].class)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //      GET JSON
    @GetMapping(value = "/item/{id}")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        try {
            Item item = itemService.getItemById(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //      ADD JSON <- not tested !!!!
    @PutMapping(value = "/item")
    public ResponseEntity<ResponseMessage> add(@RequestBody Item item) {
        try {
            itemService.addNewItem(item);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }

    }

    //      UPDATE JSON
    @PostMapping(value = "/item")
    public ResponseEntity<ResponseMessage> update(@RequestBody Item item) {
        try {
            itemService.updateItemById(item);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    //      Delete
    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id) {
        try {
            itemService.deleteItemById(id);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
}