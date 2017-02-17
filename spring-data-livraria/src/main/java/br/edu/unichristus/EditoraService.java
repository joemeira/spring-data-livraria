package br.edu.unichristus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public void salvar(Editora e) {
		this.repo.save(e);
	}

	public Editora buscarPeloNome(String nome) {
		System.out.println("OBTENDO A EDITORA DE NOME " + nome);
		return this.repo.findByNome(nome);
	}

	public void remover(Editora editora) {
		this.repo.delete(editora);
		System.out.println("EDITORA " + editora.getNome() + " REMOVIDA!");
	}

	public List<Editora> buscarPeloAnoDeFundacaoEntre(int anoInicial, int anoFinal) {
		System.out.println("OBTENDO AS EDITORAS COM ANO DE FUNDAÇÃO ENTRE " + anoInicial + " E " + anoFinal);
		return this.repo.findByAnoFundacaoBetween(anoInicial, anoFinal);
	}

	public List<Editora> buscarPelaCidade(String cidade) {
		System.out.println("OBTENDO AS EDITORAS DA CIDADE " + cidade);
		return this.repo.findByCidade(cidade);
	}

	public List<Editora> buscarIniciandoEm1Ou2(String nome1, String nome2) {
		System.out.println("OBTENDO AS EDITORAS COM NOME INICIANDO EM " + nome1 + " OU " + nome2);
		return this.repo.findByNomeStartingWithOrNomeStartingWith(nome1, nome2);
	}

	public List<Editora> buscarPorCidadeEAnoFundacaoMaiorQue(String cidade, int anoFundacao) {
		System.out.println("OBTENDO AS EDITORAS DO " + cidade + " E COM ANO DE FUNDACAO POSTERIOR A " + anoFundacao);
		return this.repo.findByCidadeAndAnoFundacaoGreaterThan(cidade, anoFundacao);
	}
}
