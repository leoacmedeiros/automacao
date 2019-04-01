package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;
import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.core.WDS;
import br.gov.mctic.sgbs.automacao.pageobject.ApagaConfigurarDisponibilidadePage;;


public class ApagaConfigurarDisponibilidadeCenario extends AbstractCenario{

	@Test
	public void ct008_ApagaConfigurarDisponibilidade() {
		acessarMenu("Declara��o", "Configurar Disponibilidade");
		aguardarCarregamento();
		Em(ApagaConfigurarDisponibilidadePage.class).solicitarAlterarDisponibilidade();
		aguardarCarregamento();
		Em(ApagaConfigurarDisponibilidadePage.class).solicitarAlterar();
		aguardarCarregamento();
		Em(ApagaConfigurarDisponibilidadePage.class).solicitarApagarDisponibilidade();
		aguardarCarregamento();
		Em(ApagaConfigurarDisponibilidadePage.class).confirmarRemocaoDisponibilidade();
		aguardarCarregamento();
		Em(ApagaConfigurarDisponibilidadePage.class).validarMensagemSucesso("Opera��o realizada com sucesso.");
		WDS.fecharNavegador();
		
	}

}
