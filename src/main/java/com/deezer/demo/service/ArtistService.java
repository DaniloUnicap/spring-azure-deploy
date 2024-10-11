package com.deezer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.demo.exception.ArtistNotFoundException;
import com.deezer.demo.model.Artist;
import com.deezer.demo.repository.ArtistRepository;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public Artist insertArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> returnAllArtists() {
        return artistRepository.findAll();
    }

    public List<Artist> getArtistByName(String name) {
        return artistRepository.findArtistByName(name);
    }

    public Optional<Artist> getArtistById(Long id) throws ArtistNotFoundException {
        Optional<Artist> optionalArtist = artistRepository.findById(id);
        if(optionalArtist.isEmpty()) {
            throw new ArtistNotFoundException("Artista não encontrado com o ID: " + id);
        }
        return artistRepository.findById(id);
    }

    public void deleteArtistById(Long id) throws ArtistNotFoundException {
        if(!artistRepository.existsById(id)){
            throw new ArtistNotFoundException("Não foi possível deletar o artista, pois não existe um artista com o ID: " + id);
        }
        artistRepository.deleteById(id);
    }

    public Artist updateArtistName(Long id, String newName) throws ArtistNotFoundException {
        Optional<Artist> optionalArtist = artistRepository.findById(id);

        if(optionalArtist.isEmpty()) {
            throw new ArtistNotFoundException("Artista não encontrado com o ID: " + id);
        }
        Artist artist = optionalArtist.get();
        artist.setName(newName);
        return artistRepository.save(artist);
    }

}
