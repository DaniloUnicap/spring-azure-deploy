package com.deezer.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deezer.demo.dto.ArtistDTO;
import com.deezer.demo.dto.MusicDTO;
import com.deezer.demo.dto.TopMusicDTO;
import com.deezer.demo.model.Artist;
import com.deezer.demo.model.Music;
import com.deezer.demo.repository.ArtistRepository;
import com.deezer.demo.repository.MusicRepository;

@Service
public class APIService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private MusicRepository musicRepository;

    public void fetchAndSaveArtist(String artistName) {
        String apiUrl = "https://api.deezer.com/artist/" + artistName;
        ArtistDTO artistDTO = restTemplate.getForObject(apiUrl, ArtistDTO.class);

        if (artistDTO != null) {
            Artist existingArtist = artistRepository.findById(artistDTO.getId()).orElse(null);
            if (existingArtist != null) {
                existingArtist.setName(artistDTO.getName());
                existingArtist.setNbAlbum(artistDTO.getNbAlbum());
                artistRepository.save(existingArtist);
            } else {
                Artist artist = new Artist();
                artist.setId(artistDTO.getId());
                artist.setName(artistDTO.getName());
                artist.setNbAlbum(artistDTO.getNbAlbum());
                artist.setMusicList(new ArrayList<>());
                artistRepository.save(artist);
            }
        }
    }

    public void fetchAndSaveMusic(String artistId) {
        String apiUrl = "https://api.deezer.com/artist/" + artistId + "/top";
        
        TopMusicDTO topMusicDTO = restTemplate.getForObject(apiUrl, TopMusicDTO.class);
        
        if (topMusicDTO != null && topMusicDTO.getData() != null) {
            List<MusicDTO> musicDTOs = topMusicDTO.getData();
    
            
            Artist artist = artistRepository.findById(Long.parseLong(artistId)).orElse(null);
            if (artist == null) {
                System.out.println("Artist not found with id: " + artistId);
                return; 
            }
    
            for (MusicDTO musicDTO : musicDTOs) {
                System.out.println("Processing music: " + musicDTO.getTitle());
    
                Music existingMusic = musicRepository.findById(musicDTO.getId()).orElse(null);
    
                if (existingMusic != null) {
                    
                    System.out.println("Updating existing music: " + musicDTO.getTitle());
                    existingMusic.setTitle(musicDTO.getTitle());
                    existingMusic.setArtist(artist);
                    musicRepository.save(existingMusic);
                } else {
                    
                    System.out.println("Saving new music: " + musicDTO.getTitle());
                    Music newMusic = new Music();
                    newMusic.setId(musicDTO.getId());
                    newMusic.setTitle(musicDTO.getTitle());
                    newMusic.setArtist(artist);
                    musicRepository.save(newMusic);
                }
            }
        } else {
            System.out.println("No music data found for artist: " + artistId);
        }
    }

}
