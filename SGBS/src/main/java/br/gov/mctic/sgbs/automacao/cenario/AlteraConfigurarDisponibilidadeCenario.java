package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;

import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.AlteraConfigurarDisponibilidadePage;

public class AlteraConfigurarDisponibilidadeCenario extends AbstractCenario{

	@Test
	public void ct008_AlterarConfigurarDisponibilidade() {
		
		acessarMenu("Declara��o", "Configurar Disponibilidade");
		Em(AlteraConfigurarDisponibilidadePage.class).solicitarEditarDisponibilidade();
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).solicitarAlterar();
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).solicitarEditarPeriodoDeclaracao();
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).informaDataInicialPeriodoDeclaracao("15022030");
		Em(AlteraConfigurarDisponibilidadePage.class).informaDataFinalPeriodoDeclaracao("15122030");
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).solicitarSalvarAlteracaoPeriodoDeclaracao();
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).validarMensagemSucessoAlteracao("Libera��o salva com sucesso.");
		Em(AlteraConfigurarDisponibilidadePage.class).solicitarEditarDeclaracoesCumprimentoExigencias();
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).informaDataInicialDeclaracaoCumprimentoExigencia("22022030");
		Em(AlteraConfigurarDisponibilidadePage.class).informaDataFinalDeclaracaoCumprimentoExigencia("22122030");
		aguardarCarregamento();
		Em(AlteraConfigurarDisponibilidadePage.class).solicitarSalvarAlteracaoDeclaracaoCumprimentoExigencia();
		Em(AlteraConfigurarDisponibilidadePage.class).validarMensagemSucessoAlteracaoPeriodoExigencia("Libera��o salva com sucesso.");
		aguardarCarregamento();
		
		
	}
	
}
