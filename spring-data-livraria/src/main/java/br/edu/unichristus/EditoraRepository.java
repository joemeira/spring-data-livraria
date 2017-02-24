package br.edu.unichristus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para o repositório de Editoras
 * @author Glaydson
 *
 */
@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

	public Editora findByNome(String nome);

	public List<Editora> findByAnoFundacaoBetween(int anoInicial, int anoFinal);

	public List<Editora> findByCidade(String cidade);

	public List<Editora> findByNomeStartingWithOrNomeStartingWith(String nome1, String nome2);

	public List<Editora> findByCidadeAndAnoFundacaoGreaterThan(String cidade, int anoFundacao);

}
