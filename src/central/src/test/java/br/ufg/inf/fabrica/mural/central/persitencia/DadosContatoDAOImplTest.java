package br.ufg.inf.fabrica.mural.central.persitencia;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.fabrica.mural.central.dominio.DadosContato;
import br.ufg.inf.fabrica.mural.central.persistencia.DadosContatoDAO;
import br.ufg.inf.fabrica.mural.central.persistencia.DadosContatoDAOImpl;

public class DadosContatoDAOImplTest {

	DadosContato dadosContato = null;

	@Before
	public void inicializa() {
		dadosContato = EasyMock.createMock(DadosContato.class);
		Long id = 1l;
		EasyMock.expect(dadosContato.getId()).andReturn(id).anyTimes();
		String tipo = "TesteTipo";
		EasyMock.expect(dadosContato.getTipo()).andReturn(tipo).anyTimes();
		String valor = "TesteValor";
		EasyMock.expect(dadosContato.getValor()).andReturn(valor).anyTimes();

		EasyMock.replay(dadosContato);

	}

	@Test
	public void testIncluir(){
		DadosContatoDAO dadosContatoDAO = new DadosContatoDAOImpl();
		assertEquals(true, dadosContatoDAO.salvar(dadosContato));

		EasyMock.verify(dadosContato);

	}

	@Test
	public void testAlterar(){
		DadosContatoDAO dadosContatoDAO = new DadosContatoDAOImpl();
		assertEquals(true, dadosContatoDAO.alterar(dadosContato));

		EasyMock.verify(dadosContato);

	}

	@Test
	public void testRemover(){
		DadosContatoDAO dadosContatoDAO = new DadosContatoDAOImpl();
		assertEquals(true, dadosContatoDAO.remover(dadosContato));

		EasyMock.verify(dadosContato);

	}

	@Test
	public void testBuscar(){
		DadosContatoDAO dadosContatoDAO = new DadosContatoDAOImpl();
		assertEquals(dadosContato, dadosContatoDAO.buscar(dadosContato));

		EasyMock.verify(dadosContato);

	}
}



