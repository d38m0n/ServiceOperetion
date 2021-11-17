package com.example.demoAPM.controllerMVC;

import com.example.demoAPM.model.Item;
import com.example.demoAPM.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController {
    @Autowired
    private ItemService itemService;


    // END POINT TO UPDATE AN Item
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditItemPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit");
        Item item = itemService.getItemById(id);
        mav.addObject("item", item);
        return mav;
    }

    @RequestMapping("/Show/{id}")
    public ModelAndView showEditItemByIDAPMPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("edit");
        Item item = itemService.getAllByIDAPMItems(id);
        mav.addObject("item", item);
        return mav;
    }

    @PostMapping(value = "/updateAPM")
    public String updateEmployee(
            @ModelAttribute("item") Item item)
    {
        itemService.updateItemById(item);
        return "redirect:/";
    }

}
