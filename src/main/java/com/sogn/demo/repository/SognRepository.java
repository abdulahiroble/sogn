package com.sogn.demo.repository;

import java.util.List;

import com.sogn.demo.models.Sogn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SognRepository extends JpaRepository<Sogn, Integer> {

    @Query(value = "SELECT SUM(s.smittetryk) FROM sogn s WHERE s.kommuneid = 2", nativeQuery = true)
    int selectTotals();
}
