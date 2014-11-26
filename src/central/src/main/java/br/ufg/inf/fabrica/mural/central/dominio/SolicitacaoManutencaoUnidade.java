package br.ufg.inf.fabrica.mural.central.dominio;

import br.ufg.inf.fabrica.mural.central.persistencia.*;

public class SolicitacaoManutencaoUnidade {
	
	static final String OPERACAO_INCLUIR = "incluir";
	static final String OPERACAO_ALTERAR = "alterar";
	static final String OPERACAO_REMOVER = "remover";
	
	static final String OPERACAO_REALIZADA_COM_SUCESSO = "2000";
	static final String OPERACAO_FALHA = "2001";
	
	Unidade unidade;
	String operacao;
	Usuario usuario;
	
	public SolicitacaoManutencaoUnidade() {
		//Construtor Padrão
	}
	
	public SolicitacaoManutencaoUnidade(Unidade unidade, String operacao) {
		this.unidade = unidade;
		this.operacao = operacao;
	}
	
	public String realizarOperacao() {
		UnidadeDAO unidadeDAO = new UnidadeDAOImpl();
		DadosContatoDAO dadosContatoDAO = new DadosContatoDAOImpl();
		PosicaoDAO posicaoDAO = new PosicaoDAOImpl();
		String codigoRetorno = OPERACAO_FALHA;
		
		switch (operacao) {
			case OPERACAO_INCLUIR:
				if (unidadeDAO.incluir(unidade) 
						&& dadosContatoDAO.incluir(unidade.getDadosContato())
						&& posicaoDAO.incluir(unidade.getPosicao())) {
					codigoRetorno = OPERACAO_REALIZADA_COM_SUCESSO;
				}
				
				break;
			case OPERACAO_ALTERAR:
				unidade = unidadeDAO.buscar(unidade);
				if (unidade != null && unidadeDAO.alterar(unidade)
						&& dadosContatoDAO.alterar(unidade.getDadosContato())
						&& posicaoDAO.alterar(unidade.getPosicao())) {
					codigoRetorno = OPERACAO_REALIZADA_COM_SUCESSO;
				}
				
				break;
			case OPERACAO_REMOVER:
				unidade = unidadeDAO.buscar(unidade);
				if (unidade != null && unidadeDAO.remover(unidade)
						&& dadosContatoDAO.remover(unidade.getDadosContato())
						&& posicaoDAO.remover(unidade.getPosicao())) {
					codigoRetorno = OPERACAO_REALIZADA_COM_SUCESSO;
				}
				
				break;
			default:
				break;
		}
		
		return codigoRetorno;
	}

}
