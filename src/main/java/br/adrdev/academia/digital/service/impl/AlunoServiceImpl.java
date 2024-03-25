package br.adrdev.academia.digital.service.impl;

import br.adrdev.academia.digital.entity.Aluno;
import br.adrdev.academia.digital.entity.AvaliacaoFisica;
import br.adrdev.academia.digital.entity.form.AlunoForm;
import br.adrdev.academia.digital.entity.form.AlunoUpdateForm;
import br.adrdev.academia.digital.infra.utils.JavaTimeUtils;
import br.adrdev.academia.digital.repository.AvaliacaoFisicaRepository;
import br.adrdev.academia.digital.service.IAlunoService;
import br.adrdev.academia.digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class  AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if(dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = repository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
    Aluno aluno = repository.findById(id).get();
    return aluno.getAvaliacoes();
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = repository.findById(id).get();
        repository.delete(aluno);
    }

}
