package com.sogn.demo.service;

import com.sogn.demo.models.Sogn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface SognListService {

    // Sletter sogn fra db ud fra sognid
    void deleteSogn(int sognid);

    // finder sogn fra db ud fra sognid
    Sogn getSognById(int sognid);
}
