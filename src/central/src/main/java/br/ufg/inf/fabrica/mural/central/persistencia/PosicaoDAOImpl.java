package br.ufg.inf.fabrica.mural.central.persistencia;

import br.ufg.inf.fabrica.mural.central.dominio.Posicao;

public class PosicaoDAOImpl implements PosicaoDAO {

	@Override
	public boolean salvar(Posicao posicao) {
		try {
			GerenciamentoConexao.persist(posicao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean alterar(Posicao posicao) {
		try {
			GerenciamentoConexao.merge(posicao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean remover(Posicao posicao) {
		try {
			GerenciamentoConexao.merge(posicao);
			GerenciamentoConexao.remove(posicao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public Posicao buscar(Posicao posicao) {
		Posicao posicaoPesquisada;
		
		try {
			GerenciamentoConexao.startConnection();
			posicaoPesquisada = GerenciamentoConexao.getEntityManager().find(Posicao.class, posicao.getId());
			GerenciamentoConexao.closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			posicaoPesquisada = null;
		}
		
		return posicaoPesquisada;
	}
	
}
