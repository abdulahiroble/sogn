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

    @GetMapping("/kommuner")
    public List<Kommune> findAllKommuner() {
        return kommuneRepository.findAll();
    }

    @GetMapping("/sogne")
    public List<Sogn> findAllSogne() {
        return sognRepository.findAll();
    }

    @PostMapping("/newsogn")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn updatesogn(@ModelAttribute("sogn") Sogn sogn) {

        System.out.println(sogn);
        return sognRepository.save(sogn);
    }

    @PostMapping(value = "/newsognjs", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn newsognjs(@RequestBody Sogn sogn, Model model) {

        Kommune kommune = sogn.getKommune();

        int y = Integer.parseInt(kommune.getKommunenavn());

        kommune.setKommuneid(y);

        return sognRepository.save(sogn);
    }

    @PostMapping("/newsognjs")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn newsogn(@ModelAttribute("booking") Sogn sogn) {

        System.out.println(sogn);
        return sognRepository.save(sogn);
    }

}
