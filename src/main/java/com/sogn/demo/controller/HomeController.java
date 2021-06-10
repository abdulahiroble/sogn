package com.sogn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.sogn.demo.models.Sogn;
import com.sogn.demo.service.SognListService;

@Controller
public class HomeController {

    @Autowired
    private SognListService sognListService;

    @GetMapping("/index")
    public String index() {
        return "/";
    }

    @GetMapping("/pricelist/{pricelistNo}")
    public String showMovieList(@PathVariable(value = "pricelistNo") int pageNo, Model model) {

        try {
            int pageSize = 10;

            Page<Sogn> page = sognListService.showMovieList(pageNo, pageSize);

            List<Sogn> listMovie = page.getContent();

            model.addAttribute("listMovie", listMovie);

        } catch (Exception e) {
            System.out.println("Error can't load up list " + e);
        }

        return "admin";
    }

    @GetMapping("updatesognlist")
    public String updatesognlist() {
        return "updatesognlist";
    }

    @GetMapping("/sognUpdate/{sognid}")
    public String sognlistUpdate(@PathVariable(value = "sognid") int sognid, Model model) {

        try {
            Sogn sognlist = sognListService.getSognById(sognid);

            model.addAttribute("sognlist", sognlist);

        } catch (Exception e) {
            System.out.println("Error can't update user profile " + e);
        }

        return "updatesognlist";
    }

    @GetMapping("/sognDelete/{sognid}")
    public String deleteSogn(@PathVariable(value = "sognid") int sognid) {

        try {
            this.sognListService.deleteSogn(sognid);
        } catch (Exception e) {
            System.out.println("Error can't delete user " + e);
        }

        return "redirect:/";
    }

    @GetMapping("/createsogn")
    public String createsogn(Model sogn, Model kommune) {

        return "createsogn";
    }

}
