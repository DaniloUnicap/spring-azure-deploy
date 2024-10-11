package com.deezer.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistDTO {
    private Long id;
    private String name;

    @JsonProperty("nb_album")
    private int nbAlbum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbAlbum() {
        return nbAlbum;
    }

    public void setNbAlbum(int nbAlbum) {
        this.nbAlbum = nbAlbum;
    }
}
