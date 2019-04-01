package br.gov.mctic.sgbs.automacao.cenario;


import org.junit.Test;
import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.AnalisarDeclaracaoAtividadesPage;

public class AnalisarDeclaracaoAtividadesCenario extends AbstractCenario{

	@Test
	public void ct007_AnalisarDeclaracaoAtividades() {
		
		acessarMenu("Declara��o","Analisar");
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).pesquisarSituacaoEnviadaParaAnalise("Enviada para An�lise");
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).verificarAchouDeclaracaoEnviadaParaAnalise();
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).selecionarSituacaoEnviadaParaAnalise();
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).selecionarAnalisarDeclaracao();
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).selecionarOpcaoSimAnalisarDeclaracao();
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).selecionarOpcaoProcessada();
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).clicarConcluirAnaliseDeclaracao();
		aguardarCarregamento();
		Em(AnalisarDeclaracaoAtividadesPage.class).validarMensagemSucessoAnaliseDeclaracao("An�lise da declara��o salva com sucesso.");
		
	}

}
