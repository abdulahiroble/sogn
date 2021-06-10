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

    // @Override
    // public Page<Sogn> showSognList(int pageNo, int pageSize) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    @Autowired
    private SognRepository sognRepository;

    @Override
    public Sogn getSognById(int sognid) {
        Optional<Sogn> optional = sognRepository.findById(sognid);

        Sogn user = null;

        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found by id " + sognid);
        }
        return user;
    }

    @Override
    public void deleteSogn(int sognid) {
        this.sognRepository.deleteById(sognid);
    }

    @Override
    public Page<Sogn> showMovieList(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return this.sognRepository.findAll(pageable);
    }

    // @Override
    // public Pricelist getPriceListById(int pricelistid) {
    // Optional<Pricelist> optional = pricelistRepository.findById(pricelistid);
    // Pricelist user = null;

    // if (optional.isPresent()) {
    // user = optional.get();
    // } else {
    // throw new RuntimeException(" User not found by id " + pricelistid);
    // }
    // return user;
    // }

}
