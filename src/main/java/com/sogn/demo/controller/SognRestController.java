package com.sogn.demo.controller;

import java.util.List;

import com.sogn.demo.models.Kommune;
import com.sogn.demo.models.Sogn;
import com.sogn.demo.repository.KommuneRepository;
import com.sogn.demo.repository.SognRepository;
import com.sogn.demo.service.SognListService;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class SognRestController {

    @Autowired
    SognRepository sognRepository;

    @Autowired
    KommuneRepository kommuneRepository;

    @Autowired
    SognListService sognListService;

    // Laver en liste af kommune og returnere dem allesammen
    @GetMapping("/kommuner")
    public List<Kommune> findAllKommuner() {

        return kommuneRepository.findAll();
    }

    // Laver en liste af sogne og returnere dem allesammen
    @GetMapping("/sogne")
    public List<Sogn> findAllSogne() {
        return sognRepository.findAll();
    }

    // Opretter en ny sogn objekt i browseren og gemmer i db
    @PostMapping("/newsognjs")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn newsognjs(@ModelAttribute("sogn") Sogn sogn) {

        System.out.println(sogn);
        return sognRepository.save(sogn);
    }

    // Tager vores form og opdatere sogn i db
    @PostMapping("/updatesognjs")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn updatesogn(@ModelAttribute("sogn") Sogn sogn) {

        System.out.println(sogn);
        return sognRepository.save(sogn);
    }

    // Opretter ny sogn i postman
    @PostMapping(value = "/newsogn", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn newSognjs(@RequestBody Sogn sogn, Model model) {

        System.out.println(sogn);
        return sognRepository.save(sogn);
    }

}
