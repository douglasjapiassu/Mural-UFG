package br.ufg.inf.fabrica.mural.central.persitencia;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.fabrica.mural.central.dominio.DadosContato;
import br.ufg.inf.fabrica.mural.central.dominio.Posicao;
import br.ufg.inf.fabrica.mural.central.dominio.Unidade;
import br.ufg.inf.fabrica.mural.central.persistencia.UnidadeDAO;
import br.ufg.inf.fabrica.mural.central.persistencia.UnidadeDAOImpl;

public class UnidadeDAOImplTest {

	Unidade unidade = null;
	Posicao posicao = null;
	DadosContato dadosContato = null;

	@Before
	public void inicializa() {
		//mockando dadosContato
		dadosContato = EasyMock.createMock(DadosContato.class);
		Long idDadosContato = 1l;
		EasyMock.expect(dadosContato.getId()).andReturn(idDadosContato).anyTimes();
		String tipo = "TesteTipo";
		EasyMock.expect(dadosContato.getTipo()).andReturn(tipo).anyTimes();
		String valor = "TesteValor";
		EasyMock.expect(dadosContato.getValor()).andReturn(valor).anyTimes();

		EasyMock.replay(dadosContato);
		
		//mockando posicao
		posicao = EasyMock.createMock(Posicao.class);
		Long idPosicao = 1l;
		EasyMock.expect(posicao.getId()).andReturn(idPosicao).anyTimes();
		Double latitude = 1d;
		EasyMock.expect(posicao.getLatitude()).andReturn(latitude).anyTimes();
		Double longitude = 1d;
		EasyMock.expect(posicao.getLongitude()).andReturn(longitude).anyTimes();

		EasyMock.replay(posicao);
		
		//mockando unidade
		unidade = EasyMock.createMock(Unidade.class);
		Long idUnidade = 1l;
		EasyMock.expect(unidade.getId()).andReturn(idUnidade).anyTimes();
		DadosContato dadosContatoUnidade = dadosContato;
		EasyMock.expect(unidade.getDadosContato()).andReturn(dadosContatoUnidade).anyTimes();
		Posicao posicaoUnidade = posicao;
		EasyMock.expect(unidade.getPosicao()).andReturn(posicaoUnidade).anyTimes();

		EasyMock.replay(unidade);

	}

	@Test
	public void testIncluir(){
		UnidadeDAO unidadeDAO = new UnidadeDAOImpl();
		assertEquals(true, unidadeDAO.incluir(unidade));

		EasyMock.verify(unidade);
	}

	@Test
	public void testAlterar(){
		UnidadeDAO unidadeDAO = new UnidadeDAOImpl();
		assertEquals(true, unidadeDAO.alterar(unidade));

		EasyMock.verify(unidade);
	}

	@Test
	public void testRemover(){
		UnidadeDAO unidadeDAO = new UnidadeDAOImpl();
		assertEquals(true, unidadeDAO.remover(unidade));

		EasyMock.verify(unidade);
	}

	@Test
	public void testBuscar(){
		UnidadeDAO unidadeDAO = new UnidadeDAOImpl();
		assertEquals(unidade, unidadeDAO.buscar(unidade));

		EasyMock.verify(unidade);
	}
}



