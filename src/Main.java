import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
	public static void main(String[] args) {

		Curso curso1 = new Curso();
		curso1.setTitulo("curso java");
		curso1.setDescricao("descricao curso java");
		curso1.setCargaHoraria(8);

		Curso curso2  = new Curso();
		curso2.setTitulo("curso js");
		curso2.setDescricao("descricao curso js");
		curso2.setCargaHoraria(4);
		
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("descricao mentoria de java");
		mentoria.setData(LocalDate.now()); // atribui a data de criação na criação do objeto
		
//		System.out.println(curso1);
//		System.out.println(curso2);
//		System.out.println(mentoria);

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev dev1 = new Dev(); // Cria um novo Objeto Dev
		dev1.setNome("Camila");// Define um nome para o nov Dev
		dev1.inscreverBootcamp(bootcamp);// Increve o dev1 no bootcamp
		System.out.println("Conteúdos Incritos Camila:" + dev1.getConteudosInscritos());
		
		System.out.println("====== APÓS PROGREDIR ======");
		dev1.progredir();
		dev1.progredir();
		System.out.println("Conteúdos Incritos Camila:" + dev1.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos Camila:" + dev1.getConteudosConcluidos());
		System.out.println("XP: " + dev1.calcularTotalXp());
		
		System.out.println("\n---------------");
		Dev dev2 = new Dev();
		dev2.setNome("João");
		dev2.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Incritos João" + dev2.getConteudosInscritos());
		
		System.out.println("====== APÓS PROGREDIR ======");
		dev2.progredir();
		dev2.progredir();
		dev2.progredir();
		System.out.println("Conteúdos Incritos João:" + dev2.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos João" + dev2.getConteudosConcluidos());
		System.out.println("XP: " + dev2.calcularTotalXp());
		
	}
}
