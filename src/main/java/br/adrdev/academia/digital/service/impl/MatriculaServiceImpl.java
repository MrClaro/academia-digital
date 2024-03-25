package br.adrdev.academia.digital.service.impl;

import br.adrdev.academia.digital.entity.Aluno;
import br.adrdev.academia.digital.entity.Matricula;
import br.adrdev.academia.digital.entity.form.MatriculaForm;
import br.adrdev.academia.digital.service.IMatriculaService;
import br.adrdev.academia.digital.repository.AlunoRepository;
import br.adrdev.academia.digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);
        return repository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null) {
            return repository.findAll();
        } else {
            return repository.findByAlunoBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {
      Matricula matricula = repository.findById(id).get();
      repository.delete(matricula);
    }
}
