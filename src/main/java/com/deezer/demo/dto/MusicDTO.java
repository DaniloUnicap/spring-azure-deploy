package com.deezer.demo.dto;

public class MusicDTO {
    private long id;
    private String title;
    private long artistId;

    // Construtores padrão
    public MusicDTO() {}

    public MusicDTO(long id, String title, long artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "MusicDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                '}';
    }
}
