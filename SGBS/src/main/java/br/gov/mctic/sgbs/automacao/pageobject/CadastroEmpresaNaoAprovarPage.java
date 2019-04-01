package br.gov.mctic.sgbs.automacao.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;


public class CadastroEmpresaNaoAprovarPage extends AbstractPageObject{
	
	
	@FindBy(xpath = "//button[contains(text(),'Analisar')]")
	private List<WebElement> botaoAnalisar;	
	
	@FindBy(xpath = "//span[text()='Análise do Cadastro']")
	private List<WebElement> abaAnaliseCadastro;	
	
	@FindBy(id = "::textarea-justificativa")
	private WebElement informarJustificativa;
	
	
	public void solicitarAnalisarEmpresa() {
		WDS.delay(500);
		for (WebElement botaoAnalisar1 : botaoAnalisar) {
		if (botaoAnalisar1.isDisplayed()) {
			botaoAnalisar1.click();
		break;
		}
	}
}

	public void confirmarInicioAnalise() {
		WDS.delay(2000);
		WDS.get().findElement(By.xpath("//md-dialog//md-dialog-actions//button[text()='Sim']")).click();
		
	}

	
	public void clicarAbaAnaliseCadastro() {
		WDS.delay(500);
		for (WebElement abaAnaliseCadastro1 : abaAnaliseCadastro) {
		if (abaAnaliseCadastro1.isDisplayed()) {
			abaAnaliseCadastro1.click();
		break;
		}
	}
}

	public void clicarSituacaoNaoAprovada() {
		WDS.get().findElement(By.id("nao-aprovado")).click();
		
	}

	public void inserirJustificativa() {
		informarJustificativa.click();
		informarJustificativa.sendKeys("Empresa não aprovada. Não preenche aos requisitos.");
				
	}

	public void clicarBotaoSalvar() {
		WDS.get().findElement(By.xpath("//button//span[text()='Salvar']")).click();
		
	}
	

}
