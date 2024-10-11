package com.deezer.demo.openapi;


import com.deezer.demo.exception.MusicNotFoundException;
import com.deezer.demo.model.Music;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@Tag(name = "Música")
public interface MusicControllerOpenApi {
    
    @Operation(summary = "Buscar música por título")
    List<Music> findMusicByTitle (String title) throws MusicNotFoundException;

    @Operation(summary = "Buscar música por ID")
    Optional<Music> getMusicById(Long id) throws MusicNotFoundException;

    @Operation(summary = "Adicionar uma música")
    Music addMusic(Music music);

    @Operation(summary = "Deletar música")
    void deleteMusictById(Long id) throws MusicNotFoundException;

    @Operation(summary = "Atualizar música por ID")
    Music updateMusicTitle(Long id, Music music) throws MusicNotFoundException;

    @Operation(summary = "Retornar todas as músicas")
    List<Music> getAllMusic();
}
