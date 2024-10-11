package com.deezer.demo.dto;

import java.util.List;

public class TopMusicDTO {
    private List<MusicDTO> data;

    // Getters e Setters
    public List<MusicDTO> getData() {
        return data;
    }

    public void setData(List<MusicDTO> data) {
        this.data = data;
    }
}
