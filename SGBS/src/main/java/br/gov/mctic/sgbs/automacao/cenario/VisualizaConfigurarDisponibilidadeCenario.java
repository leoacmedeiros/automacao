package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;

import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.VisualizaConfigurarDisponibilidadePage;


public class VisualizaConfigurarDisponibilidadeCenario extends AbstractCenario{

	@Test
	public void ct008_VisualizaConfigurarDisponibilidade() {
		
		acessarMenu("Declaração", "Configurar Disponibilidade");
		Em(VisualizaConfigurarDisponibilidadePage.class).solicitarEditarDisponibilidade();
		aguardarCarregamento();
		Em(VisualizaConfigurarDisponibilidadePage.class).solicitarVisualizar();
		aguardarCarregamento();
		Em(VisualizaConfigurarDisponibilidadePage.class).verificarAnoCadastrado();		
		aguardarCarregamento();
		
	}



}
