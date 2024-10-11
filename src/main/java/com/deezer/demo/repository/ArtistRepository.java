package com.deezer.demo.repository;

import org.springframework.stereotype.Repository;
import com.deezer.demo.model.Artist;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    public List<Artist> findArtistByName(String name);
    
}


