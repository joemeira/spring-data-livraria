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

//@SpringBootApplication
public class SpringDataLivrariaApplicationAutor implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	@Autowired
	private AutorService servicoAutores;

	@Override
	public void run(String... args) throws ParseException {

		/*
		 * REGRAS DE INCLUSÃO
		 * 
		 * --> Editora e Autor podem ser incluídos sem nenhuma relação com outra classe. --> Ao incluir um Livro, é
		 * preciso: setar a Editora (Livro é o lado dominante) obter/criar o Autor e setar o livro no Autor salvar o
		 * Livro e o Autor
		 * 
		 */

		// Incluindo uma nova editora
		Editora e = new Editora("Érica", "Rio de Janeiro", 1937);

		// Incluindo um novo autor
		Autor a = new Autor("Antonio", "José", "Brasil");

		// Incluindo um novo livro. É preciso dizer qual é a editora
		Livro l = new Livro("Java em 30 dias", LocalDate.now(), 250, new BigDecimal("15.00"));
		l.setEditora(e);

		// Configurando o autor do livro
		a.setLivros(new ArrayList<Livro>() {
			{
				add(l);
			}
		});

		// SALVANDO AS ENTIDADES - OBSERVE A ORDEM
		this.servicoEditoras.salvar(e);
		this.servicoLivros.salvar(l);
		this.servicoAutores.salvar(a);

		
		
		/* INSERINDO UM NOVO LIVRO PARA AUTOR E EDITORA JÁ EXISTENTES */
		Livro l2 = new Livro("Java em 90 dias", LocalDate.of(2015, 3, 30), 300, new BigDecimal("50.00"));
		l2.setEditora(servicoEditoras.buscarPeloNome("Campus"));
		Autor antonio = servicoAutores.buscarPeloID(7L);
		antonio.getLivros().add(l2);
		this.servicoLivros.salvar(l2);
		this.servicoAutores.salvar(antonio);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplicationAutor.class, args);
	}
}
