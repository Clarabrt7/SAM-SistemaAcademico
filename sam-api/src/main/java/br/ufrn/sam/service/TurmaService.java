package br.ufrn.sam.service;

import br.ufrn.sam.model.TurmaModel;
import br.ufrn.sam.repository.JpaTurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TurmaService {

    private final JpaTurmaRepository turmaRepository;

    public TurmaService(JpaTurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaModel cadastrar(TurmaModel turma) {
        if (turmaRepository.findByCodigo(turma.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Código de turma já cadastrado: " + turma.getCodigo());
        }
        return turmaRepository.save(turma);
    }

    public TurmaModel buscarPorCodigo(String codigo) {
        return turmaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new NoSuchElementException("Turma não encontrada: " + codigo));
    }

    public List<TurmaModel> listarTodas() {
        return turmaRepository.findAll();
    }
}
