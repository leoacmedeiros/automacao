package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;
import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.CadastroConfigurarDisponibilidadePage;

public class CadastroConfigurarDisponibilidadeCenario extends AbstractCenario {

	@Test
	public void ct008_configurarDisponibilidade() {
		acessarMenu("Declara��o", "Configurar Disponibilidade");
		Em(CadastroConfigurarDisponibilidadePage.class).solicitarLiberarCadastro();
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataInicial("01012030");
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataFinal("31122030");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).selecionarTipoDeclaracao("Realizadas");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarMensagemCampoObrigatorioAnoReferencia("O campo � de preenchimento obrigat�rio");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).informarAnoReferencia("2030");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).solicitarLiberarDisponibilidade();
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarMensagemSucessoLiberar("Libera��o salva com sucesso.");
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataInicialDeclaracoesCumprimentoExigencias("02012030");
		Em(CadastroConfigurarDisponibilidadePage.class).informarDataFinalDeclaracoesCumprimentoExigencias("31122030");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).solicitarLiberarDeclaracoesCumprimentoExigencias();
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarMensagemSucessoPeriodoExigencias("Per�odo de exig�ncias salvo com sucesso!");
		acessarMenu("Declara��o", "Consultar / Cadastrar");
		aguardarCarregamento();
		acessarMenu("Declara��o", "Configurar Disponibilidade");
		aguardarCarregamento();
		Em(CadastroConfigurarDisponibilidadePage.class).validarDisponibilidadeCadastrada();
	}

}
