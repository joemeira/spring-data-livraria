package br.edu.unichristus;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataLivrariaApplicationAutor implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	@Override
	public void run(String... args) throws ParseException {

		// Incluindo uma nova editora
		Editora e = new Editora("Érica", "Rio de Janeiro", 1937);
		

		// Incluindo um novo livro
		Livro livro = new Livro("Java Como Programar", LocalDate.now(), 250, new BigDecimal("15.00"));
		livro.setEditora(e);
		this.servicoEditoras.salvar(e);
		this.servicoLivros.salvar(livro);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplicationAutor.class, args);
	}
}
