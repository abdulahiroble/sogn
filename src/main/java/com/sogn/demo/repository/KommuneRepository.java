package com.sogn.demo.repository;

import java.util.List;

import com.sogn.demo.models.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

}
