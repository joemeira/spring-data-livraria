package br.edu.unichristus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repo;

	/* MÉTODOS CRUD */

	/**
	 * Salva um autor no repositório.
	 * 
	 * @param autor
	 *            Autor que se deseja gravar
	 */
	public void salvar(Autor autor) {
		this.repo.save(autor);
		System.out.println("AUTOR " + autor.getAutorID() + " SALVO!");
	}

	/**
	 * Obtém a lista de todos os autores cadastrados.
	 * 
	 * @return Lista de autores cadastrados.
	 */
	public List<Autor> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE AUTORES");
		return this.repo.findAll();
	}

	/**
	 * Busca um autor pelo seu ID
	 * 
	 * @param idAutor
	 *            ID do autor que se deseja buscar
	 * @return Autor com o id informado.
	 */
	public Autor buscarPeloID(Long idAutor) {
		System.out.println("OBTENDO O AUTOR COM O ID = " + idAutor);
		return this.repo.findOne(idAutor);
	}

	/**
	 * Busca os autores com os IDs informados.
	 * 
	 * @param idsAutores
	 *            IDs dos autores que se deseja buscar.
	 * @return Lista de autores com os IDs informados
	 */
	public List<Autor> buscarPelosIDs(ArrayList<Long> idsAutores) {
		System.out.println("OBTENDO OS AUTORES COM OS IDS " + idsAutores.toString());
		return this.repo.findAll(idsAutores);
	}

	/**
	 * Remove um autor do repositório pelo seu ID
	 * 
	 * @param idAutor
	 *            que se deseja remover
	 */
	public void remover(Long idAutor) {
		this.repo.delete(idAutor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + idAutor);
	}

	/**
	 * Remove um autor do repositório
	 * 
	 * @param autor
	 *            Autor que se deseja remover.
	 */
	public void remover(Autor autor) {
		this.repo.delete(autor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + autor.getAutorID());
	}

}
