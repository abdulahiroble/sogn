package com.sogn.demo.controller;

import java.util.List;

import com.sogn.demo.models.Sogn;
import com.sogn.demo.repository.SognRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SognRestController {

    @Autowired
    SognRepository sognRepository;

    @GetMapping("/sogne")
    public List<Sogn> findAllSogne() {
        return sognRepository.findAll();
    }

}
