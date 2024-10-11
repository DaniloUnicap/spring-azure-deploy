package com.deezer.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.demo.model.Artist;
import com.deezer.demo.openapi.ArtistControllerOpenAPI;
import com.deezer.demo.service.ArtistService;

@RequestMapping("api/artist/")
@RestController
public class ArtistController implements ArtistControllerOpenAPI{
    @Autowired
    public ArtistService artistService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Artist insertArtist(@RequestBody Artist artist) {
        return artistService.insertArtist(artist);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Artist> getAllArtist() {
        return artistService.returnAllArtists();
    }

    @GetMapping("/{nameArtist}")
    public List<Artist> getArtistByName(@PathVariable String nameArtist) {
        return artistService.getArtistByName(nameArtist);
    }

    @GetMapping("/id/{id}")
    public Optional<Artist> getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtistById(@PathVariable Long id) {
        artistService.deleteArtistById(id);
    }

    @PutMapping("/updateName/{id}")
    public Artist updateArtistName(@PathVariable Long id, @RequestBody Artist artist) {
        return artistService.updateArtistName(id, artist.getName());
    }

}
