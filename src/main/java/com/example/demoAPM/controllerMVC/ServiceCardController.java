package com.example.demoAPM.controllerMVC;

import com.example.demoAPM.model.ServiceCard;
import com.example.demoAPM.service.ServiceCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/serviceOrders")
public class ServiceCardController {
    @Autowired
    private ServiceCardService serviceCardService;

    @RequestMapping("/show")
    public String viewAllServiceCard(
            Model model) {
        List<ServiceCard> allServiceCard = serviceCardService.getAPMNameServiceCardAPMID();
        model.addAttribute("allServiceCard", allServiceCard);
        return "serviceOrders";
    }

    @RequestMapping("/worker-view/{idAPM}")
    public String showServiceCardWorkerView(
            Model model,
            @PathVariable(name = "idAPM") String id) {
            List<ServiceCard> allServiceCard = serviceCardService.getAPMNameServiceCardWorkerID(id);
        model.addAttribute("allServiceCard", allServiceCard);

        return "serviceCardWorkerView";
    }

    @RequestMapping("/show/{idAPM}")
    public String showServiceCardPage(
            Model model,
            @PathVariable(name = "idAPM") String id) {
        List<ServiceCard> allServiceCard = serviceCardService.getAPMNameServiceCardAPMID(id);
        model.addAttribute("allServiceCard", allServiceCard);

        return "serviceOrders";
    }

    @RequestMapping("/edit/{idSC}")
    public ModelAndView editServiceCardPage(@PathVariable(name = "idSC") Long id) {
        ModelAndView mav = new ModelAndView("serviceCardEdit");
        ServiceCard serviceCard = serviceCardService.getServiceCardById(id);
        mav.addObject("serviceCard", serviceCard);
        return mav;
    }

    @RequestMapping("/worker/{idSC}")
    public ModelAndView showWorkerServiceCardPage(@PathVariable(name = "idSC") Long id) {
        ModelAndView mav = new ModelAndView("serviceCardWorker");
        ServiceCard serviceCard = serviceCardService.getServiceCardById(id);
        mav.addObject("serviceCard", serviceCard);
        return mav;
    }

    @RequestMapping("/new/{idAPM}")
    public String addNewServiceCardPage(
            Model model,
            @PathVariable(name = "idAPM") String id) {
        ServiceCard serviceCard = new ServiceCard();
        serviceCard.setaPMNumber(id);
        List<ServiceCard> allServiceCard = serviceCardService.getAPMNameServiceCardAPMID(id);
        model.addAttribute("allServiceCards", allServiceCard);
        model.addAttribute("serviceCard", serviceCard);
        return "serviceCard";
    }

    @PostMapping(value = "/save")
    public String addNewServiceCard(
            @ModelAttribute("serviceCard") ServiceCard serviceCard) {
        serviceCardService.addNewServiceCard(serviceCard);
        return "redirect:/serviceOrders/new/" + serviceCard.getaPMNumber();
    }

    @PostMapping(value = "/update")
    public String updateServiceCard(
            @ModelAttribute("serviceCard") ServiceCard serviceCard) {
        serviceCardService.addNewServiceCard(serviceCard);
        return "redirect:/serviceOrders/edit/" + serviceCard.getId();
    }

    @PostMapping(value = "/update-worker")
    public String updateServiceCardWorker(
            @ModelAttribute("serviceCard") ServiceCard serviceCard) {
        serviceCardService.addNewServiceCard(serviceCard);
        return "redirect:/serviceOrders/worker-view/" + serviceCard.getPersonWork();
    }

    @RequestMapping("/delete/{id}")
    public String deleteItem(@PathVariable(name = "id") Long id) {
        serviceCardService.deleteServiceCardId(id);
        return "redirect:/serviceOrders/show";
    }
}
