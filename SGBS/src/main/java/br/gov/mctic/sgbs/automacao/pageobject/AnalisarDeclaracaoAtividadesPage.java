package br.gov.mctic.sgbs.automacao.pageobject;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;
import org.junit.Assert;

public class AnalisarDeclaracaoAtividadesPage extends AbstractPageObject{
	
	WebDriverWait wait;

	@FindBy(xpath = "//button[contains(text(),'Analisar')]")
	private List<WebElement> botaoAnalisar;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement mensagemSucessoAnaliseDeclaracao;
	
	public void pesquisarSituacaoEnviadaParaAnalise(String situacaoSelecionada) {
		WDS.get().findElement(By.xpath("//h2[text()='Consultar Declaração de Atividade']")).click();
		WDS.delay(1000);
		WDS.get().findElement(By.name("situacao")).click();
		WDS.delay(500);
		WDS.get().findElement(By.xpath("//div[text()= '"+ situacaoSelecionada +"' ]")).click();
		WDS.delay(500);
		WDS.get().findElement(By.xpath("//span[text()='Pesquisar']")).click();
	}

	public void verificarAchouDeclaracaoEnviadaParaAnalise() {
		try {
			boolean achouDeclaracaoEnviadaParaAnalise = WDS.get().getPageSource().contains("Enviada para Análise");
			assertTrue(achouDeclaracaoEnviadaParaAnalise);
			System.out.println("ANALISAR DECLARAÇÕES DE ATIVIDADES: Declaração com situação: Enviada para Análise, encontrada!");
		}catch(AssertionError e){
				System.out.print("Mensagem Erro: Declaração com situação: Enviada para Análise, não encontrada!");
			}
		
	}
	
	public void selecionarSituacaoEnviadaParaAnalise() {
		WDS.delay(1500);
		WDS.get().findElement(By.xpath("//table//tbody//tr[1]//button")).click();
		
						
	}

	public void selecionarAnalisarDeclaracao() {
			WDS.delay(1000);
			for (WebElement botaoAnalisar1 : botaoAnalisar) {
			if (botaoAnalisar1.isDisplayed()) {
				botaoAnalisar1.click();
			break;
			}
		}
		
	}

	public void selecionarOpcaoSimAnalisarDeclaracao() {
		WDS.delay(1000);
		WDS.get().findElement(By.xpath("//md-dialog-actions//button[text()='Sim']")).click();
		WDS.delay(1000);
	}

	public void selecionarOpcaoProcessada() {
		WDS.delay(1500);
		WDS.get().findElement(By.xpath("//md-radio-group//md-radio-button[@aria-label='Processada']")).click();
		WDS.delay(1000);
	}

	public void clicarConcluirAnaliseDeclaracao() {
		WDS.get().findElement(By.xpath("//span[text()='Concluir']")).click();
		
	}

	public void validarMensagemSucessoAnaliseDeclaracao(String mensagemSucessoExibida) {
		try {
			Assert.assertEquals(mensagemSucessoExibida, mensagemSucessoAnaliseDeclaracao.getText());
			System.out.println("ANALISAR DECLARAÇÕES DE ATIVIDADES: Mensagem validada ---> Análise da declaração salva com sucesso.");
		}catch(AssertionError e){
				System.out.print("Mensagem Erro: Mensagem de sucesso não exibida.");
			}
				
	}

	


	
}
