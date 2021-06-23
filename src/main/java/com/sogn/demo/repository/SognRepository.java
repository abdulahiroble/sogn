package com.sogn.demo.repository;

import java.util.List;

import com.sogn.demo.models.Sogn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Forbinder til vores database via JPA hvor har adgang til indbyggede metoder 
@Repository
public interface SognRepository extends JpaRepository<Sogn, Integer> {

    // Lavede en custom query som udregner total summen af vores smittetryk i sogn
    // tabel ud fra kommuneid
    @Query(value = "SELECT SUM(s.smittetryk) FROM sogn s WHERE s.kommuneid = 1", nativeQuery = true)
    int selectTotals();
}
