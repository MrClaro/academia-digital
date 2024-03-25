package br.adrdev.academia.digital.service.impl;

import br.adrdev.academia.digital.entity.Aluno;
import br.adrdev.academia.digital.entity.AvaliacaoFisica;
import br.adrdev.academia.digital.entity.form.AvaliacaoFisicaForm;
import br.adrdev.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import br.adrdev.academia.digital.service.IAvaliacaoFisicaService;
import br.adrdev.academia.digital.repository.AlunoRepository;
import br.adrdev.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return repository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return repository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = repository.findById(id).get();
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        avaliacaoFisica.setPeso(formUpdate.getPeso());

        return repository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
       AvaliacaoFisica avaliacaoFisica = repository.findById(id).get();
       repository.delete(avaliacaoFisica);
    }


}
