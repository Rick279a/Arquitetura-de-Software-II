package org.example.controller;

import org.example.constant.Constant;
import org.example.model.Atividade;
import org.example.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constant.API)
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public Atividade save(@Valid @RequestBody Atividade atividade) {
        return atividadeService.save(atividade);
    }

    @GetMapping
    public List<Atividade> findAll() {
        return atividadeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Atividade> findById(@PathVariable("id") String id) {
        return atividadeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        atividadeService.delete(id);
    }
}
