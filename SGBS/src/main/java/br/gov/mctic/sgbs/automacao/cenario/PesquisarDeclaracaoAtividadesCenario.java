package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;
import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.PesquisarDeclaracaoAtividadesPage;

public class PesquisarDeclaracaoAtividadesCenario extends AbstractCenario{

	@Test
	public void ct007_PesquisarDeclaracaoAtividades() {
		acessarMenu("Declaração","Analisar");
		aguardarCarregamento();
		Em(PesquisarDeclaracaoAtividadesPage.class).abrirMenuPesquisa();
		aguardarCarregamento();
		Em(PesquisarDeclaracaoAtividadesPage.class).pesquisarPorAnoReferencia("2020");
		aguardarCarregamento();
		Em(PesquisarDeclaracaoAtividadesPage.class).validarPesquisaAnoReferencia();
		aguardarCarregamento();
		Em(PesquisarDeclaracaoAtividadesPage.class).limparPesquisa();
	}

}
