package com.deezer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.demo.exception.MusicNotFoundException;
import com.deezer.demo.model.Music;
import com.deezer.demo.repository.MusicRepository;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    public List<Music> findMusicByTitle (String title) throws MusicNotFoundException {
         List<Music> opTitle = musicRepository.findMusicByTitle(title);

         if(opTitle.isEmpty()){
            throw new MusicNotFoundException("Title " + title + " not found" );
         }
         return musicRepository.findMusicByTitle(title);
    }

    public Optional<Music> getMusicById (Long id) throws MusicNotFoundException{
        Optional <Music> opMusic = musicRepository.findById(id);

        if(opMusic.isEmpty()){
            throw new MusicNotFoundException("Music " + id + " not found");
        }
        return musicRepository.findById(id);
    }

    public Music addMusic(Music music) {
        if (music.getTitle() == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        if (music.getArtist() == null) {
            throw new IllegalArgumentException("Artist cannot be null");
        }
        return musicRepository.save(music);
    }


    public boolean deleteMusicById(Long id) throws MusicNotFoundException{
        Optional <Music> opMusic = musicRepository.findById(id);

        if (opMusic.isEmpty()){
            return false;
        }

        Music u = opMusic.get();
        musicRepository.delete(u);
        return true;
    }

    public Music updateMusicById (Long id, String newName) throws MusicNotFoundException{
        Optional <Music> opMusic = musicRepository.findById(id);

        if(opMusic.isEmpty()){
            throw new MusicNotFoundException("Music " + id + " not found");
        }

        Music u = opMusic.get();
        u.setTitle(newName);
        return musicRepository.save(u);
    }
    public List<Music> returnAllMusic() {
        return musicRepository.findAll();
    }
}

