package com.sogn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.sogn.demo.models.Kommune;
import com.sogn.demo.models.Sogn;
import com.sogn.demo.repository.KommuneRepository;
import com.sogn.demo.repository.SognRepository;
import com.sogn.demo.service.SognListService;

@Controller
public class HomeController {

    @Autowired
    private SognListService sognListService;

    @Autowired
    private SognRepository sognRepository;

    @Autowired
    KommuneRepository kommuneRepository;

    // Retunerer vores index side
    @GetMapping("/index")
    public String index() {
        return "/";
    }

    // Henter vores kommune side og beregne total smittetyk for kommune
    @GetMapping("/sekommuner")
    public String kommuner() {

        System.out.println(sognRepository.selectTotals());

        return "kommuner";
    }

    // Returnere update siden hvor man kan opdatere sogne
    @GetMapping("updatesognlist")
    public String updatesognlist() {
        return "updatesognlist";
    }

    // Finder specifikke sogn id og giver en fejl hvis ugyldigt id ellers returnere
    // den opdatesognlist.html
    @GetMapping("/sognUpdate/{sognid}")
    public String sognlistUpdate(@PathVariable(value = "sognid") int sognid, Model model) {

        try {
            Sogn sognlist = sognListService.getSognById(sognid);

            model.addAttribute("sognlist", sognlist);

        } catch (Exception e) {
            System.out.println("Error can't update sogn " + e);
        }

        return "updatesognlist";
    }

    // Finder specifikke id og slette det og derefter redirecter til index siden
    @GetMapping("/sognDelete/{sognid}")
    public String deleteSogn(@PathVariable(value = "sognid") int sognid) {

        try {
            this.sognListService.deleteSogn(sognid);
        } catch (Exception e) {
            System.out.println("Error can't delete sogn " + e);
        }

        return "redirect:/";
    }

    // Returnere create sogn siden på dette endpoint
    @GetMapping("/createsogn")
    public String createsogn(Model sogn, Model kommune) {

        return "createsogn";
    }

}
