package br.ufg.inf.fabrica.mural.central.dominio;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class SolicitacaoManutencaoUnidadeTest {

	@Test
	public void test() {
		Usuario usuario = EasyMock.createMock(Usuario.class);
		EasyMock.expect(usuario.getLogin()).andReturn("teste");
		EasyMock.expect(usuario.getSenha()).andReturn("teste");
	}

}
