package br.edu.unichristus;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para o repositório de Livros
 * @author Glaydson
 *
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	// OPERADORES DE STRING

	public Livro findByTitulo(String titulo);

	public List<Livro> findByTituloLike(String titulo);

	public List<Livro> findByTituloContaining(String titulo);

	public List<Livro> findByTituloStartingWith(String titulo);

	public List<Livro> findByTituloEndingWith(String titulo);

	public List<Livro> findByTituloIgnoreCase(String titulo);

	// OPERADORES RELACIONAIS

	public List<Livro> findByNumeroPaginasEquals(int numeroPaginas);

	public List<Livro> findByNumeroPaginasGreaterThan(int numeroPaginas);

	public List<Livro> findByNumeroPaginasBetween(int min, int max);

	// OPERADORES LÓGICOS

	public List<Livro> findByTituloContainingOrTituloContaining(String titulo1, String titulo2);

	public List<Livro> findByTituloNot(String titulo);

	public List<Livro> findByTituloContainingAndNumeroPaginasGreaterThan(String titulo, int numeroPaginas);

	// OPERADORES DE DATA

	public List<Livro> findByDataPublicacaoAfter(LocalDate dataPublicacao);

	public List<Livro> findByDataPublicacaoBefore(LocalDate dataPublicacao);

	public List<Livro> findByDataPublicacaoBetween(LocalDate dataPublicacao1, LocalDate dataPublicacao2);

	// ORDENAÇÃO DE DADOS

	public List<Livro> findByTituloContainingOrderByTituloAsc(String titulo);

	public List<Livro> findByTituloContainingOrderByTituloDesc(String titulo);

	// CONSULTAS ENVOLVENDO AUTORES
	public List<Livro> findByAutoresPrimeiroNome(String primeiroNome);

	public List<Livro> findByAutores_Pais(String pais);

}
