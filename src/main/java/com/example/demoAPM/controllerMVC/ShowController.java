package com.example.demoAPM.controllerMVC;

import com.example.demoAPM.model.Item;
import com.example.demoAPM.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowController {
    @Autowired
    private ItemService itemService;


    @RequestMapping("/show/{id}")
    public ModelAndView showItemPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("show");
        Item item = itemService.getItemById(id);
        mav.addObject("item", item);
        return mav;
    }

}
