package br.edu.unichristus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe que oferece os serviços relativos a livros.
 * 
 * @author Glaydson
 *
 */
@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;

	/* MÉTODOS CRUD */

	/**
	 * Salva um livro no repositório.
	 * 
	 * @param livro
	 *            Livro que se deseja gravar
	 */
	public void salvar(Livro livro) {
		this.repo.save(livro);
		System.out.println("LIVRO " + livro.getLivroID() + " SALVO!");
	}

	/**
	 * Obtém a lista de todos os livros cadastrados.
	 * 
	 * @return Lista de livros cadastrados.
	 */
	public List<Livro> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE LIVROS");
		return this.repo.findAll();
	}

	/**
	 * Busca um livro pelo seu ID
	 * 
	 * @param idLivro
	 *            ID do livro que se deseja buscar
	 * @return Livro com o id informado.
	 */
	public Livro buscarPeloID(Long idLivro) {
		System.out.println("OBTENDO O LIVRO COM O ID = " + idLivro);
		return this.repo.findOne(idLivro);
	}

	/**
	 * Busca os livros com os IDs informados.
	 * 
	 * @param idsLivros
	 *            IDs dos livros que se deseja buscar.
	 * @return Lista de livros com os IDs informados
	 */
	public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
		System.out.println("OBTENDO OS LIVROS COM OS IDS " + idsLivros.toString());
		return this.repo.findAll(idsLivros);
	}

	/**
	 * Remove um livro do repositório pelo seu ID
	 * 
	 * @param idLivro
	 *            que se deseja remover
	 */
	public void remover(Long idLivro) {
		this.repo.delete(idLivro);
		System.out.println("REMOVIDO O LIVRO COM ID = " + idLivro);
	}

	/**
	 * Remove um livro do repositório
	 * 
	 * @param livro
	 *            Livro que se deseja remover.
	 */
	public void remover(Livro livro) {
		this.repo.delete(livro);
		System.out.println("REMOVIDO O LIVRO COM ID = " + livro.getLivroID());
	}

	/* MÉTODOS DE PESQUISA COM STRINGS */
	/**
	 * Busca um livro pelo seu título
	 * 
	 * @param titulo
	 *            Título do livro que se deseja buscar.
	 * @return Livro com o título informado.
	 */
	public Livro buscarPeloTitulo(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO " + titulo);
		return this.repo.findByTitulo(titulo);
	}

	/**
	 * Busca os livros que contenham a máscara informada.
	 * 
	 * @param mascara
	 *            Máscara que se deseja buscar.
	 * @return Lista de Livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloLike(String mascara) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO LIKE " + mascara);
		return this.repo.findByTituloLike(mascara);
	}

	/**
	 * Busca os livros que contenham a máscara informada
	 * 
	 * @param mascara
	 *            Máscara que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloContendo(String mascara) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO CONTENDO " + mascara);
		return this.repo.findByTituloContaining(mascara);
	}

	/**
	 * Busca os livros cujo título começa pela string informada.
	 * 
	 * @param string
	 *            String que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloComecandoCom(String string) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO COMEÇANDO COM " + string);
		return this.repo.findByTituloStartingWith(string);
	}

	/**
	 * Busca os livros cujo título termina pela string informada.
	 * 
	 * @param string
	 *            String que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloTerminandoCom(String string) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO TERMINANDO EM " + string);
		return this.repo.findByTituloEndingWith(string);
	}

	/**
	 * Busca os livros pelo seu título, ignorando a capitalização
	 * 
	 * @param titulo
	 *            Título do livro que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO " + titulo + " IGNORANDO A CAPITALIZAÇÃO");
		return this.repo.findByTituloIgnoreCase(titulo);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES RELACIONAIS */
	/**
	 * Busca os livros que tenham o número de páginas informado.
	 * 
	 * @param numeroPaginas
	 *            Número de páginas que se deseja buscar
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloNumeroDePaginas(int numeroPaginas) {
		System.out.println("BUSCANDO OS LIVROS COM O NÚMERO DE PÁGINAS IGUAL A  " + numeroPaginas);
		return this.repo.findByNumeroPaginasEquals(numeroPaginas);
	}

	/**
	 * Busca os livros cujo número de páginas seja maior que o valor informado.
	 * 
	 * @param numeroPaginas
	 *            Número de páginas que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloNumeroDePaginasMaiorQue(int numeroPaginas) {
		System.out.println("BUSCANDO OS LIVROS COM O NÚMERO DE PÁGINAS MAIOR QUE  " + numeroPaginas);
		return this.repo.findByNumeroPaginasGreaterThan(numeroPaginas);
	}

	/**
	 * Busca livros que contenham o número de páginas dentro do intervalo
	 * especificado
	 * 
	 * @param min
	 *            Número de páginas mínimo
	 * @param max
	 *            Número de páginas máximo
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloNumeroDePaginasIntervalo(int min, int max) {
		System.out.println("BUSCANDO OS LIVROS COM O NÚMERO DE PÁGINAS ENTRE  " + min + " E " + max);
		return this.repo.findByNumeroPaginasBetween(min, max);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES LÓGICOS */
	/**
	 * Busca os livros que contenham uma ou as duas máscaras informadas como
	 * parâmetro.
	 * 
	 * @param mascara1
	 *            Primeira máscara de busca.
	 * @param mascara2
	 *            Segunda máscara de busca.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloContendo1ou2(String titulo1, String titulo2) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO CONTENDO " + titulo1 + " OU " + titulo2);
		return this.repo.findByTituloContainingOrTituloContaining(titulo1, titulo2);
	}

	/**
	 * Busca livros cujo título seja diferente do título informado.
	 * 
	 * @param titulo
	 *            Título que se deseja eliminar da busca.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloDiferenteDe(String titulo) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO DIFERENTE DE " + titulo);
		return this.repo.findByTituloNot(titulo);
	}

	/**
	 * Busca os livros cujo título contenha a máscara informada e cujo número de
	 * páginas seja maior que o número informado
	 * 
	 * @param mascara
	 *            Máscara que se deseja buscar.
	 * @param numeroPaginas
	 *            Número de páginas que se deseja buscar.
	 * @return Lista de livros que satisfazem os parâmetros informados.
	 */
	public List<Livro> buscarPeloTituloContendoENumeroDePaginasMaiorQue(String mascara, int numeroPaginas) {
		System.out.println("BUSCANDO OS LIVROS COM O TÍTULO IGUAL A " + mascara + " E NÚMERO DE PÁGINAS MAIOR QUE "
				+ numeroPaginas);
		return this.repo.findByTituloContainingAndNumeroPaginasGreaterThan(mascara, numeroPaginas);
	}

	/* MÉTODOS DE PESQUISA COM OPERADORES DE DATA */
	/**
	 * Busca os livros cuja data de publicação seja posterior à data informada.
	 * 
	 * @param dataPublicacao
	 *            Data de publicação que se deseja pesquisar.
	 * @return Lista de livros que satisfazem a pesquisa
	 */
	public List<Livro> buscarPelaDataPublicacaoDepoisDe(LocalDate dataPublicacao) {
		System.out.println("BUSCANDO OS LIVROS COM DATA DE PUBLICAÇÃO DEPOIS DE " + dataPublicacao);
		return this.repo.findByDataPublicacaoAfter(dataPublicacao);
	}

	/**
	 * Busca os livros cuja data de publicação seja anterior à data informada.
	 * 
	 * @param dataPublicacao
	 *            Data de publicação que se deseja pesquisar.
	 * @return Lista de livros que satisfazem a pesquisa
	 */
	public List<Livro> buscarPelaDataPublicacaoAntesDe(LocalDate dataPublicacao) {
		System.out.println("BUSCANDO OS LIVROS COM DATA DE PUBLICAÇÃO ANTES DE " + dataPublicacao);
		return this.repo.findByDataPublicacaoBefore(dataPublicacao);
	}

	/**
	 * Busca os livros cuja data de publicação esteja entre as datas informadas
	 * como parâmetro
	 * 
	 * @param dataPublicacao1
	 *            Data de publicação inicial
	 * @param dataPublicacao2
	 *            Data de publicação final
	 * @return Lista de livros que satisfazem a pesquisa
	 */
	public List<Livro> buscarPelaDataPublicacaoEntre(LocalDate dataPublicacao1, LocalDate dataPublicacao2) {
		System.out.println(
				"BUSCANDO OS LIVROS COM DATA DE PUBLICAÇÃO ENTRE " + dataPublicacao1 + " E " + dataPublicacao2);
		return this.repo.findByDataPublicacaoBetween(dataPublicacao1, dataPublicacao2);
	}

	/* MÉTODOS DE ORDENAÇÃO */
	/**
	 * Busca livros cujo título contém a máscara informada, em ordem crescente
	 * de título
	 * 
	 * @param mascara
	 *            Máscara que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloContendoOrdemCrescente(String mascara) {
		System.out.println("BUSCANDO OS LIVROS COM TÍTULO CONTENDO " + mascara + " EM ORDEM CRESCENTE");
		return this.repo.findByTituloContainingOrderByTituloAsc(mascara);
	}

	/**
	 * Busca livros cujo título contém a máscara informada, em ordem decrescente
	 * de título
	 * 
	 * @param mascara
	 *            Máscara que se deseja buscar.
	 * @return Lista de livros que satisfazem a pesquisa.
	 */
	public List<Livro> buscarPeloTituloContendoOrdemDecrescente(String mascara) {
		System.out.println("BUSCANDO OS LIVROS COM TÍTULO CONTENDO " + mascara + " EM ORDEM DECRESCENTE");
		return this.repo.findByTituloContainingOrderByTituloDesc(mascara);
	}
}
