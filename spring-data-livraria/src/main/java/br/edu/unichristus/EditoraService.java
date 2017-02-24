package br.edu.unichristus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public void salvar(Editora e) {
		this.repo.save(e);
		System.out.println("EDITORA " + e.getEditoraID() + " SALVA!");
	}
}
