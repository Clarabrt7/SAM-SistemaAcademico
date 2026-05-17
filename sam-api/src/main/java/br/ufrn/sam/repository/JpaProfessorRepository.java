package br.ufrn.sam.repository;

import br.ufrn.sam.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaProfessorRepository extends JpaRepository<ProfessorModel, Integer> {
    Optional<ProfessorModel> findBySiape(String siape);
}
