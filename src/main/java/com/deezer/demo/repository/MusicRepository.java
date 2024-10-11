package com.deezer.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deezer.demo.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

    public List<Music> findMusicByTitle(String title);
}

