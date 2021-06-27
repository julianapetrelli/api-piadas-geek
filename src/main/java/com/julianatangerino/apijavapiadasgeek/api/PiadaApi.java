package com.julianatangerino.apijavapiadasgeek.api;

import com.julianatangerino.apijavapiadasgeek.model.Piada;
import com.julianatangerino.apijavapiadasgeek.services.PiadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/piadas/api")
@RestController
public class PiadaApi {

    @Autowired
    private PiadaService service;

    @GetMapping("/mostrartudo")
    public ResponseEntity<List<Piada>> listarToda() {

        List<Piada> piadas = service.mostrarTodos();
        return ResponseEntity.ok().body(piadas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piada> buscarPorId(@PathVariable Integer id){
        Piada piada = service.buscarPorId(id);
        return ResponseEntity.ok().body(piada);
    }

    @PostMapping("/novaPiada")
    public ResponseEntity<Void> novaPiada(@RequestBody Piada piada){
        Piada novaPiada = service.salvarPiada(piada);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaPiada.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/apagarPiada/{id}")
    public ResponseEntity<Void> apagarPiada(@PathVariable Integer id){
        service.apagarPiada(id);

        return ResponseEntity.noContent().build();
    }
}
