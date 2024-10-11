package com.deezer.demo.controller;

import java.util.List;
import java.util.Optional;

import com.deezer.demo.openapi.MusicControllerOpenApi;
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

import com.deezer.demo.exception.MusicNotFoundException;
import com.deezer.demo.model.Music;
import com.deezer.demo.service.MusicService;


@RestController
@RequestMapping(value="/api/music/")
public class MusicController implements MusicControllerOpenApi{

    @Autowired
    public MusicService musicService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Music> getAllMusic() {
        return musicService.returnAllMusic();
    }

    @GetMapping("/id/{id}")
    public Optional<Music> getMusicById(@PathVariable Long id) throws MusicNotFoundException {
        return musicService.getMusicById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Music addMusic(@RequestBody Music music) {
        return musicService.addMusic(music);
    }
    
    @PutMapping("/updateTitle/{id}")
    public Music updateMusicTitle(@PathVariable Long id, @RequestBody Music music) throws MusicNotFoundException {
        return musicService.updateMusicById(id, music.getTitle());
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteMusictById(@PathVariable Long id) throws MusicNotFoundException {
        musicService.deleteMusicById(id);
    }

    @GetMapping("title/{titleMusic}")
    public List<Music> findMusicByTitle(@PathVariable String titleMusic) throws MusicNotFoundException {
        return musicService.findMusicByTitle(titleMusic);
    }
}
