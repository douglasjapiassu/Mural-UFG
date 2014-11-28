package br.ufg.inf.fabrica.mural.central.persitencia;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ufg.inf.fabrica.mural.central.dominio.Posicao;
import br.ufg.inf.fabrica.mural.central.persistencia.GerenciamentoConexao;
import br.ufg.inf.fabrica.mural.central.persistencia.PosicaoDAO;
import br.ufg.inf.fabrica.mural.central.persistencia.PosicaoDAOImpl;

public class PosicaoDAOImplTest {

	@BeforeClass
	public static void inicializa() {
		Posicao posicao = new Posicao(500.0, 520.0);
		Posicao posicao2 = new Posicao(600.0, 620.0);
		
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		
		assertEquals(true, posicaoDAO.salvar(posicao));
		assertEquals(true, posicaoDAO.salvar(posicao2));
	}

	@Test
	public void testSalvar(){
		Posicao posicao = new Posicao(250.0, 320.0);
		
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		assertEquals(true, posicaoDAO.salvar(posicao));
	}

	@Test
	public void testAlterar(){
		Posicao posicaoAlteracao;
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		
		//Busca qualquer item do banco de dados:
		GerenciamentoConexao.startConnection();
		List<Posicao> listaDePosicoes = GerenciamentoConexao.getEntityManager().createQuery("select p from Posicao p", Posicao.class).getResultList();
		GerenciamentoConexao.closeConnection();
		posicaoAlteracao = listaDePosicoes.get(0);
		
		//Alterando longitude e latitude
		posicaoAlteracao.setLatitude(900.0);
		posicaoAlteracao.setLongitude(800.0);
		
		assertEquals(true, posicaoDAO.alterar(posicaoAlteracao));
	}

	@Test
	public void testRemover(){
		Posicao posicaoExclusao;
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		
		//Busca qualquer item do banco de dados:
		GerenciamentoConexao.startConnection();
		List<Posicao> listaDePosicoes = GerenciamentoConexao.getEntityManager().createQuery("select p from Posicao p", Posicao.class).getResultList();
		GerenciamentoConexao.closeConnection();
		posicaoExclusao = listaDePosicoes.get(0);
		
		assertEquals(true, posicaoDAO.remover(posicaoExclusao));
	}

	
}



