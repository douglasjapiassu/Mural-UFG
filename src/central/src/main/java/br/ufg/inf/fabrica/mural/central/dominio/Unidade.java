package br.ufg.inf.fabrica.mural.central.dominio;

import br.ufg.inf.fabrica.mural.central.suporte.GenericEntity;

public class Unidade extends GenericEntity {
	
	private String nome;
	private DadosContato dadosContato;
	private Posicao posicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DadosContato getDadosContato() {
		return dadosContato;
	}

	public void setDadosContato(DadosContato dadosContato) {
		this.dadosContato = dadosContato;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

}
