// Usando 'Set' pois não é permitido mais de uma inscrição no mesmo conteúdo/ curso
// Usando 'LinkedHashSet' para manter a ordenação das inscrições dos conteúdos
// Uso do polimorfismo 'Set' -> 'LinkedHashSet'. Evita acoplamento
/* '.stream()' é um método usado para criar um fluxo de dados (Stream) a partir de uma coleção, como List, Set ou Map.
	Esse fluxo permite processar dados de forma funcional (sem loops explícitos) com métodos como filter(), map(), collect(), etc. */

package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	
	public void inscreverBootcamp(Bootcamp bootcamp) {		
		this.conteudosInscritos.addAll(bootcamp.getConteudos()); // Adicionado em 'conteudosInscritos' todo o conteúdo do 'bootcamp'
		bootcamp.getDevsInscritos().add(this); // Adicionei o 'dev' Atual (this) ao 'bootcamp'
		
	}
	
	public void progredir() {
		// Uso do 'Optional' para lidar com retorno 'null'
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		// se existir conteúdo
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get()); // adiciono o 'conteudo' a 'conteudosConcluidos'
			this.conteudosInscritos.remove(conteudo.get()); // removo o 'conteudo' de 'conteudosInscritos'
		}else {
			System.err.println("Você não está matriculado em nenhum curso!");
		}
	}
	
	public double calcularTotalXp() {
		return this.conteudosConcluidos
				.stream()
				.mapToDouble(conteudo -> conteudo.calcularXp()) // peguei cada 'conteudo' de dentro do Set-> peguei o 'Xp' de cada conteúdo
				.sum(); // Fiz a soma dos 'Xps'
		
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}
	
	
}
