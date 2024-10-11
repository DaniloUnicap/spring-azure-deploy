package com.deezer.demo.openapi;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API externa")
public interface APIControllerOpenApi {

    @Operation(summary = "Buscar informações do artista na API externa e salvar no banco de dados. Exemplo de busca: Bruno-Mars")
    ResponseEntity<String> getAllData(String artistName);

    @Operation(summary = "Buscar informações das músicas na API externa e salvar no banco de dados")
    ResponseEntity<String> getMusicData(String artistId);
}