package com.example.demoAPM.controllerMVC;

import com.example.demoAPM.dto.ItemDTO;
import com.example.demoAPM.model.Item;

import com.example.demoAPM.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private ItemService itemService;




    // END POINT TO FETCH ALL Items
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<ItemDTO> listItems = itemService.getItemsDTO();
        model.addAttribute("listItems", listItems);
        return "index";
    }


    @RequestMapping("/csvItem")
    public String viewCSVItemPage() {
        return "csvItem";
    }

    @GetMapping(value = "/allAPM")
    public List<Item> findAllItems() {
        return itemService.getAllItems();
    }

    // END POINT TO FETCH SINGLE Item
    @GetMapping(value = "/findAPM/{id}")
    public Item findItemById(@PathVariable(value = "id") Long id) {
        return itemService.getItemById(id);
    }


    // END POINT TO DELETE AN Item
    @RequestMapping("/delete/{id}")
    public String deleteItem(@PathVariable(name = "id") Long id) {
        itemService.deleteItemById(id);
        return "redirect:/";
    }

}