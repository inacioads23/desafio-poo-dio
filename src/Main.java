import java.time.LocalDate;
import java.util.Set;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
	public static void main(String[] args) {

		Curso cursoJava = criarCurso("Curso Java", "Descrição curso Java", 8);
		Curso cursoJs = criarCurso("Curso JS", "Descrição Curso JS", 4);
		Mentoria mentoria = criarMentoria("Mentoria Java", "Descrição mentoria Java");

		Bootcamp bootcamp = criarBootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer",
				Set.of(cursoJava, cursoJs, mentoria));

		Dev devCamila = new Dev(); // Cria um novo Objeto Dev
		devCamila.setNome("Camila");// Define um nome para o nov Dev
		devCamila.inscreverBootcamp(bootcamp);// Increve o dev1 no bootcamp
		exibirStatusDev(devCamila, "Início");

		devCamila.progredir();
        devCamila.progredir();
        exibirStatusDev(devCamila, "Progresso");

        System.out.println("-----------------------------\n");
        
		Dev devJoao = new Dev();
		devJoao.setNome("João");
		devJoao.inscreverBootcamp(bootcamp);
		exibirStatusDev(devJoao, "Início");

		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		exibirStatusDev(devJoao, "Progresso");
	}

	private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
		Curso curso = new Curso();
		curso.setTitulo(titulo);
		curso.setDescricao(descricao);
		curso.setCargaHoraria(cargaHoraria);
		return curso;
	}

	private static Mentoria criarMentoria(String titulo, String descricao) {
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo(titulo);
		mentoria.setDescricao(descricao);
		mentoria.setData(LocalDate.now()); // atribui a data de criação na criação do objeto
		return mentoria;
	}

	private static Bootcamp criarBootcamp(String nome, String descricao, Set<Conteudo> conteudos) {
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome(nome);
		bootcamp.setDescricao(descricao);
		bootcamp.getConteudos().addAll(conteudos);
		return bootcamp;
	}
	
	private static void exibirStatusDev(Dev dev, String fase) {
        System.out.println("====== " + fase.toUpperCase() + " ======");
        System.out.println("Dev: " + dev.getNome());
        System.out.println("Conteúdos Inscritos:");
        dev.getConteudosInscritos().forEach(c -> System.out.println(" - " + c.getTitulo()));
        System.out.println("\nConteúdos Concluídos:");
        dev.getConteudosConcluidos().forEach(c -> System.out.println(" - " + c.getTitulo()));
        System.out.println("\nXP Total: " + dev.calcularTotalXp() + "\n");
    }

}
