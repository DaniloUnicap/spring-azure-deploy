package com.deezer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.demo.openapi.APIControllerOpenApi;
import com.deezer.demo.service.APIService;

@RestController
@RequestMapping("/api")
public class APIController implements APIControllerOpenApi{

    @Autowired
    private APIService apiService;

    @GetMapping("/data/{artistName}")
    public ResponseEntity<String> getAllData(@PathVariable String artistName) {
        apiService.fetchAndSaveArtist(artistName);
        return ResponseEntity.ok("Artista salvo com sucesso");
    }

    @GetMapping("/music/{artistId}")
    public ResponseEntity<String> getMusicData(@PathVariable String artistId) {
        apiService.fetchAndSaveMusic(artistId);
        return ResponseEntity.ok("Dados das músicas salvos com sucesso");
    }
}
