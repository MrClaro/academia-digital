package br.adrdev.academia.digital.controller;

import br.adrdev.academia.digital.entity.AvaliacaoFisica;
import br.adrdev.academia.digital.entity.form.AvaliacaoFisicaForm;
import br.adrdev.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import br.adrdev.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }


    @PutMapping("{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm form) {
        return service.update(id, form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public AvaliacaoFisica getById(@PathVariable Long id) {
       return service.get(id);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
