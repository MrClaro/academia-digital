package br.adrdev.academia.digital.controller;

import br.adrdev.academia.digital.entity.form.MatriculaForm;
import br.adrdev.academia.digital.entity.Matricula;
import br.adrdev.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }


}
