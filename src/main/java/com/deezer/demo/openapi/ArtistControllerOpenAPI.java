package com.deezer.demo.openapi;


import com.deezer.demo.model.Artist;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@Tag(name = "Artista")
public interface ArtistControllerOpenAPI {

    @Operation(summary = "Inserir um artista")
    Artist insertArtist(Artist artist);

    @Operation(summary = "Listar todos os artistas")
    List<Artist> getAllArtist();

    @Operation(summary = "Buscar artista pelo nome")
    List<Artist> getArtistByName(String nameArtist);

    @Operation(summary = "Buscar artista pelo ID")
    Optional<Artist> getArtistById(Long id);
    
    @Operation(summary = "Deletar artista pelo ID")
    void deleteArtistById(Long id);

    @Operation(summary = "Atualizar nome do artista")
    Artist updateArtistName(Long id, Artist artist);
}
