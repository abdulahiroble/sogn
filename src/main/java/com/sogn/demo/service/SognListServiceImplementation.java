package com.sogn.demo.service;

import java.util.Optional;

import com.sogn.demo.models.Sogn;
import com.sogn.demo.repository.SognRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SognListServiceImplementation implements SognListService {

    @Autowired
    private SognRepository sognRepository;

    // finder sogn fra db ud fra sognid
    @Override
    public Sogn getSognById(int sognid) {
        Optional<Sogn> optional = sognRepository.findById(sognid);

        Sogn sogn = null;

        if (optional.isPresent()) {
            sogn = optional.get();
        } else {
            throw new RuntimeException(" Sogn not found by id " + sognid);
        }
        return sogn;
    }

    // Sletter sogn fra db ud fra sognid
    @Override
    public void deleteSogn(int sognid) {
        this.sognRepository.deleteById(sognid);
    }

}
