package br.ufrn.sam.service;

import br.ufrn.sam.model.AlunoModel;
import br.ufrn.sam.model.InteresseModel;
import br.ufrn.sam.model.TurmaModel;
import br.ufrn.sam.repository.JpaAlunoRepository;
import br.ufrn.sam.repository.JpaInteresseRepository;
import br.ufrn.sam.repository.JpaTurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InteresseService {

    private final JpaInteresseRepository interesseRepository;
    private final JpaAlunoRepository alunoRepository;
    private final JpaTurmaRepository turmaRepository;

    public InteresseService(JpaInteresseRepository interesseRepository,
                            JpaAlunoRepository alunoRepository,
                            JpaTurmaRepository turmaRepository) {
        this.interesseRepository = interesseRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public InteresseModel cadastrar(Integer idAluno, Integer idTurma) {
        // busca o aluno pelo id
        AlunoModel aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new NoSuchElementException("Aluno não encontrado: " + idAluno));

        // busca a turma pelo id
        TurmaModel turma = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new NoSuchElementException("Turma não encontrada: " + idTurma));

        // verifica se já existe interesse do aluno nessa turma
        if (!interesseRepository.findByAlunoIdAluno(idAluno).isEmpty()) {
            List<InteresseModel> interesses = interesseRepository.findByAlunoIdAluno(idAluno);
            for (InteresseModel i : interesses) {
                if (i.getTurma().getIdTurma().equals(idTurma)) {
                    throw new IllegalArgumentException("Aluno já manifestou interesse nessa turma!");
                }
            }
        }

        InteresseModel interesse = new InteresseModel(
                java.time.LocalDate.now().toString(),
                null,
                aluno,
                turma
        );

        return interesseRepository.save(interesse);
    }

    public List<InteresseModel> listarPorAluno(Integer idAluno) {
        return interesseRepository.findByAlunoIdAluno(idAluno);
    }

    public List<InteresseModel> listarPorTurma(Integer idTurma) {
        return interesseRepository.findByTurmaIdTurma(idTurma);
    }

    public List<InteresseModel> listarTodos() {
        return interesseRepository.findAll();
    }
}