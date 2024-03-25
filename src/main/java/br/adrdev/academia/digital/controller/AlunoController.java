package br.adrdev.academia.digital.controller;

import br.adrdev.academia.digital.entity.form.AlunoForm;
import br.adrdev.academia.digital.entity.Aluno;
import br.adrdev.academia.digital.entity.AvaliacaoFisica;
import br.adrdev.academia.digital.entity.form.AlunoUpdateForm;
import br.adrdev.academia.digital.service.impl.AlunoServiceImpl;
import br.adrdev.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @Autowired
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }


    @GetMapping("{id}")
    public Aluno getById(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        return service.getAll(dataDeNascimento);

    }

    @PutMapping("/atualizar/{id}")
    public Aluno update( @PathVariable Long id, @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }


    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @DeleteMapping("{id}")
    public Aluno delete(@PathVariable Long id) {
        service.delete(id);
        return null;
    }



}
