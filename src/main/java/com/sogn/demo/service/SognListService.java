package com.sogn.demo.service;

import com.sogn.demo.models.Sogn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface SognListService {

    Page<Sogn> showMovieList(int pageNo, int pageSize);

    void deleteSogn(int sognid);

    Sogn getSognById(int sognid);
}
