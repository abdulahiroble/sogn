package com.sogn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.sogn.demo.models.Sogn;
import com.sogn.demo.service.SognListService;

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

}
