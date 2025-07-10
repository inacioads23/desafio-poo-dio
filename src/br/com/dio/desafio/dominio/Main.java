package br.com.dio.desafio.dominio;

import java.time.LocalDate;

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
		
		System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(mentoria);

	}
}
