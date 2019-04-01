package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;
import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.core.WDS;
import br.gov.mctic.sgbs.automacao.pageobject.CadastroEmpresaNaoAprovarPage;
import br.gov.mctic.sgbs.automacao.pageobject.CadastroEmpresaPage;
import br.gov.mctic.sgbs.automacao.pageobject.ConsultaEmpresaPage;

public class CadastroEmpresaNaoAprovarCenario extends AbstractCenario{
	
	@Test
	public void ct001_CadastroEmpresaNaoAprovar() {
		acessarMenu("Empresa", "Analisar");
		aguardarCarregamento();
		Em(ConsultaEmpresaPage.class).solicitarPesquisarEmpresaCnpj();
		aguardarCarregamento();
		Em(ConsultaEmpresaPage.class).validarResultadoPesquisaEmpresa();
		aguardarCarregamento();
		Em(ConsultaEmpresaPage.class).clicarBotaoAcoes();
		aguardarCarregamento();
		Em(CadastroEmpresaNaoAprovarPage.class).solicitarAnalisarEmpresa();
		aguardarCarregamento();
		Em(CadastroEmpresaNaoAprovarPage.class).confirmarInicioAnalise();
		aguardarCarregamento();
		Em(CadastroEmpresaNaoAprovarPage.class).clicarAbaAnaliseCadastro();
		aguardarCarregamento();
		Em(CadastroEmpresaNaoAprovarPage.class).clicarSituacaoNaoAprovada();
		aguardarCarregamento();
		Em(CadastroEmpresaNaoAprovarPage.class).inserirJustificativa();
		aguardarCarregamento();
		Em(CadastroEmpresaNaoAprovarPage.class).clicarBotaoSalvar();
		aguardarCarregamento();
		Em(CadastroEmpresaPage.class).validarMensagem("Operação realizada com sucesso.");
		WDS.fecharNavegador();
		
	}

}
