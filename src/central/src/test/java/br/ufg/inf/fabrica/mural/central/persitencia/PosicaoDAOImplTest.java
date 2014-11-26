package br.ufg.inf.fabrica.mural.central.persitencia;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.fabrica.mural.central.dominio.Posicao;
import br.ufg.inf.fabrica.mural.central.persistencia.PosicaoDAO;
import br.ufg.inf.fabrica.mural.central.persistencia.PosicaoDAOImpl;

public class PosicaoDAOImplTest {

	Posicao posicao = null;

	@Before
	public void inicializa() {
		posicao = EasyMock.createMock(Posicao.class);
		Long id = 1l;
		EasyMock.expect(posicao.getId()).andReturn(id).anyTimes();
		Double latitude = 1d;
		EasyMock.expect(posicao.getLatitude()).andReturn(latitude).anyTimes();
		Double longitude = 1d;
		EasyMock.expect(posicao.getLongitude()).andReturn(longitude).anyTimes();

		EasyMock.replay(posicao);

	}

	@Test
	public void testIncluir(){
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		assertEquals(true, posicaoDAO.incluir(posicao));

		EasyMock.verify(posicao);

	}

	@Test
	public void testAlterar(){
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		assertEquals(true, posicaoDAO.alterar(posicao));

		EasyMock.verify(posicao);

	}

	@Test
	public void testRemover(){
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		assertEquals(true, posicaoDAO.remover(posicao));

		EasyMock.verify(posicao);

	}

	@Test
	public void testBuscar(){
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		assertEquals(posicao, posicaoDAO.buscar(posicao));

		EasyMock.verify(posicao);

	}
}



