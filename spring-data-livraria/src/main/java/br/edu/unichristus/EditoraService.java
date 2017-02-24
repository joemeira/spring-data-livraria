package br.edu.unichristus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe que oferece os serviços relativos a editoras.
 * 
 * @author Glaydson
 *
 */
@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	/**
	 * Salva uma editora no repositório
	 * 
	 * @param e
	 *            Editora a ser gravada.
	 */
	public void salvar(Editora e) {
		this.repo.save(e);
		System.out.println("EDITORA " + e.getEditoraID() + " SALVA!");
	}

	/**
	 * Busca uma editora pelo seu nome
	 * 
	 * @param nome
	 *            Nome da editora que se deseja buscar.
	 * @return Editora cujo nome é igual ao nome recebido como parâmetro
	 */
	public Editora buscarPeloNome(String nome) {
		System.out.println("OBTENDO A EDITORA DE NOME " + nome);
		return this.repo.findByNome(nome);
	}

	/**
	 * Remove uma editora do repositório.
	 * 
	 * @param editora
	 *            Editora que se deseja remover
	 */
	public void remover(Editora editora) {
		this.repo.delete(editora);
		System.out.println("EDITORA " + editora.getNome() + " REMOVIDA!");
	}

	/**
	 * Busca as editoras cujo ano de fundação esteja dentro do período
	 * informado.
	 * 
	 * @param anoInicial
	 *            Ano inicial do período
	 * @param anoFinal
	 *            Ano final do período
	 * @return Lista de Editoras que satisfazem a busca.
	 */
	public List<Editora> buscarPeloAnoDeFundacaoEntre(int anoInicial, int anoFinal) {
		System.out.println("OBTENDO AS EDITORAS COM ANO DE FUNDAÇÃO ENTRE " + anoInicial + " E " + anoFinal);
		return this.repo.findByAnoFundacaoBetween(anoInicial, anoFinal);
	}

	/**
	 * Busca as editoras de uma determinada cidade
	 * 
	 * @param cidade
	 *            Cidade para a qual se deseja obter as editoras.
	 * @return Lista de editoras que satisfazem a busca.
	 */
	public List<Editora> buscarPelaCidade(String cidade) {
		System.out.println("OBTENDO AS EDITORAS DA CIDADE " + cidade);
		return this.repo.findByCidade(cidade);
	}

	/**
	 * Busca as editoras cujo nome iniciam em qualquer dos nomes passados como
	 * parâmetro.
	 * 
	 * @param nome1
	 *            Primeiro nome que se deseja buscar.
	 * @param nome2
	 *            Segundo nome que se deseja buscar.
	 * @return Lista de editoras que satisfazem a busca.
	 */
	public List<Editora> buscarIniciandoEm1Ou2(String nome1, String nome2) {
		System.out.println("OBTENDO AS EDITORAS COM NOME INICIANDO EM " + nome1 + " OU " + nome2);
		return this.repo.findByNomeStartingWithOrNomeStartingWith(nome1, nome2);
	}

	/**
	 * Busca as editoras de uma determinada cidade e cujo ano de fundação seja
	 * maior que o ano passado como parâmetro.
	 * 
	 * @param cidade
	 *            Cidade para a qual se deseja obter as editoras
	 * @param anoFundacao
	 *            Ano de fundação a partir do qual se deseja obter as editoras
	 * @return Lista de editoras que satisfazem a busca.
	 */
	public List<Editora> buscarPorCidadeEAnoFundacaoMaiorQue(String cidade, int anoFundacao) {
		System.out.println("OBTENDO AS EDITORAS DO " + cidade + " E COM ANO DE FUNDACAO POSTERIOR A " + anoFundacao);
		return this.repo.findByCidadeAndAnoFundacaoGreaterThan(cidade, anoFundacao);
	}
}
