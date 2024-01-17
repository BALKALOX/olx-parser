package com.example.olxparser.controller;

import com.example.olxparser.entity.PlayStation;
import com.example.olxparser.repository.PlayStationRepository;
import com.example.olxparser.service.impl.ParsePlayStationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/parse")
@AllArgsConstructor
public class ParseController {

    private ParsePlayStationServiceImpl parsePlayStationService;
    private PlayStationRepository repository;

    @GetMapping
    public List<PlayStation> getAll() {
        return repository.findAll();
    }

    @PostMapping("/playstation")
    public ResponseEntity<?> testMethod(@RequestBody String url) {
        System.out.println(url);
        try {
            parsePlayStationService.parsePlayStation(url);
            return ResponseEntity.ok("Successfully parsed: " + url);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error parsing: " + url);
        }
    }

}