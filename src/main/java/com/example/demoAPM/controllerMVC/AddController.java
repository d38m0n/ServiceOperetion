package com.example.demoAPM.controllerMVC;

import com.example.demoAPM.model.Item;
import com.example.demoAPM.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {

    @Autowired
    private ItemService itemService;


    // END POINT TO ADD NEW Item
    @RequestMapping("/new")
    public String showNewItemPage(Model model) {

        Item item = new Item();
        model.addAttribute("item", item);
        return "add";
    }

    @PostMapping(value = "/save")
    public String addNewItem(
            @ModelAttribute("item") Item item) {
        itemService.addNewItem(item);
        return "redirect:/new";
    }

}
