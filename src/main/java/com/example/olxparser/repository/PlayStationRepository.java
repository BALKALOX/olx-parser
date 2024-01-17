package com.example.olxparser.repository;

import com.example.olxparser.entity.PlayStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayStationRepository extends JpaRepository<PlayStation,Long> {

    PlayStation save(PlayStation playStation);

    Optional<PlayStation> findById(Long id);
    void deleteById(Long id);

    List<PlayStation> findAll();


//    List<PlayStation> findAllByPriceBetween(double from, double to);
}
