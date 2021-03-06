package br.ufg.inf.fabrica.mural.central.dominio;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class SolicitacaoManutencaoUnidadeTest {
	static final String OPERACAO_INCLUIR = "incluir";
	static final String OPERACAO_ALTERAR = "alterar";
	static final String OPERACAO_REMOVER = "remover";
	
	static final String OPERACAO_REALIZADA_COM_SUCESSO = "2000";
	static final String OPERACAO_FALHA = "2001";
	
	Unidade unidade;
	Posicao posicao = null;
	DadosContato dadosContato = null;
	String operacao = "";
	
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
	public void testIncluir() {
		operacao = OPERACAO_INCLUIR;
		test();
	}

	@Test
	public void testAlterar() {
		operacao = OPERACAO_ALTERAR;
		test();
	}
	
	@Test
	public void testRemover() {
		operacao = OPERACAO_REMOVER;
		test();
	}
	
	public void test() {
		SolicitacaoManutencaoUnidade solicitacaoManutencao = new SolicitacaoManutencaoUnidade(unidade, operacao);
		assertEquals(OPERACAO_REALIZADA_COM_SUCESSO, solicitacaoManutencao.realizarOperacao());
		
		EasyMock.verify(unidade);
	}

}
