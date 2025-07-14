// Uso do polimorfismo 'Set' -> 'LinkedHashSet'. Evita acoplamento
// Uso do polimorfismo 'Set' -> 'HashSet'. Evita acoplamento

package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
	
	private String nome;
	private String descricao;
	// 'final' porque não poderá ser alterada
	private final LocalDate dataInicial = LocalDate.now(); // data em que instaciar o objeto
	private final LocalDate dataFim = dataInicial.plusDays(45); // dataInicial + 45 dias
	private Set<Conteudo> conteudos = new LinkedHashSet<Conteudo>(); // manter a ordenação de inscrição
	private Set<Dev> devsInscritos = new HashSet<>(); // A ordenação não é importante
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Conteudo> getConteudos() {
		return conteudos;
	}
	
	public void setConteudos(Set<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	public Set<Dev> getDevsInscritos() {
		return devsInscritos;
	}
	
	public void setDevsInscritos(Set<Dev> devsInscritos) {
		this.devsInscritos = devsInscritos;
	}
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(conteudos, dataFim, dataInicial, descricao, devsInscritos, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bootcamp other = (Bootcamp) obj;
		return Objects.equals(conteudos, other.conteudos) && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicial, other.dataInicial) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(devsInscritos, other.devsInscritos) && Objects.equals(nome, other.nome);
	}
	

}
