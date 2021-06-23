package com.sogn.demo.repository;

import java.util.List;

import com.sogn.demo.models.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

// Forbinder til vores database via JPA hvor har adgang til indbyggede metoder 
public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

}
