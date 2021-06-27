package com.julianatangerino.apijavapiadasgeek.services;

import com.julianatangerino.apijavapiadasgeek.model.Piada;
import com.julianatangerino.apijavapiadasgeek.repositories.PiadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiadaService {

    @Autowired
    private PiadaRepository repository;

    public List<Piada> mostrarTodos() {
        return repository.findAll();
    }

    public Piada buscarPorId(Integer id) {
        Optional<Piada> piada = repository.findById(id);
        return piada.orElse(new Piada());
    }

    public Piada salvarPiada(Piada piada){
        Piada novaPiada = repository.save(piada);
        piada.setId(novaPiada.getId());
        return piada;
    }

    public void apagarPiada(Integer id){
        repository.deleteById(id);
    }
}
