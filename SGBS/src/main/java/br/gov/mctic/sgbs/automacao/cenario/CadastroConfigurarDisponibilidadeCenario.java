package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;
import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.CadastroConfigurarDisponibilidadePage;

public class CadastroConfigurarDisponibilidadeCenario extends AbstractCenario {

	@Test
	public void ct008_configurarDisponibilidade() {
		acessarMenu("Declaração", "Configurar Disponibilidade");
		Em(CadastroConfigurarDisponibilidadePage.class).solicitarLiberarCadastro();
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataInicial("01012030");
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataFinal("31122030");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).selecionarTipoDeclaracao("Realizadas");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarMensagemCampoObrigatorioAnoReferencia("O campo é de preenchimento obrigatório");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).informarAnoReferencia("2030");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).solicitarLiberarDisponibilidade();
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarMensagemSucessoLiberar("Liberação salva com sucesso.");
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataInicialDeclaracoesCumprimentoExigencias("02012030");
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataFinalDeclaracoesCumprimentoExigencias("31122030");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).solicitarLiberarDeclaracoesCumprimentoExigencias();
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarMensagemSucessoPeriodoExigencias("Período de exigências salvo com sucesso!");
		acessarMenu("Declaração", "Consultar / Cadastrar");
		aguardarCarregamento();
		acessarMenu("Declaração", "Configurar Disponibilidade");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarDisponibilidadeCadastrada();
	}

}
