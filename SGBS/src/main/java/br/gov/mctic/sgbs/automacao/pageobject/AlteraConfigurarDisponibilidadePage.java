package br.gov.mctic.sgbs.automacao.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;
import org.junit.Assert;

public class AlteraConfigurarDisponibilidadePage extends AbstractPageObject{
	
	WebDriverWait wait;

	
	@FindBy(xpath = "//button[contains(text(),'Alterar')]")
	private List<WebElement> botaoAlterar;		
			
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement mensagemSucessoAlteracao;

	
	public void solicitarEditarDisponibilidade() {
		WDS.get().findElement(By.xpath("//table//tr[contains(.,'2030')]//td//md-menu")).click();
	
	}
	
	public void solicitarAlterar() {
		WDS.delay(500);
		for (WebElement botaoAlterar1 : botaoAlterar) {
		if (botaoAlterar1.isDisplayed()) {
		botaoAlterar1.click();
		break;
		}
	}
}

	public void solicitarEditarPeriodoDeclaracao() {
		WDS.get().findElement(By.xpath("//form[@id='disponibilidade']//button[@id='editar']")).click();
		WDS.delay(1000);
		
	}

	public void informaDataInicialPeriodoDeclaracao(String informarDataInicial) {
		WebElement dataInicial = WDS.get().findElement(By.xpath("//*[@id='data-inicial']//md-input-container//md-datepicker//div//input"));
		dataInicial.click();
		dataInicial.clear();
		dataInicial.sendKeys(informarDataInicial);
		
	}

	public void informaDataFinalPeriodoDeclaracao(String informarDataFinal) {
		
		WebElement dataFinal = WDS.get().findElement(By.xpath("//*[@id='data-final']//md-input-container//md-datepicker//div//input"));
		dataFinal.click();
		dataFinal.clear();
		dataFinal.sendKeys(informarDataFinal);
				
	}

	public void solicitarSalvarAlteracaoPeriodoDeclaracao() {
		WDS.get().findElement(By.xpath("//form[@id='disponibilidade']//span[contains(text(),'Salvar')]")).click();
		
	}

	public void validarMensagemSucessoAlteracao(String mensagemSucessoAlteracaoApresentada) {
		Assert.assertEquals(mensagemSucessoAlteracaoApresentada, mensagemSucessoAlteracao.getText());
		System.out.println("ALTERAR DISPONIBILIDADE: Mensagem de alteração Período de Declarações validada: Liberação salva com sucesso.");
		
	}
	

	public void solicitarEditarDeclaracoesCumprimentoExigencias() {
		WDS.get().findElement(By.xpath("//form[@id='disponibilidade-exigencia']//button[@id='editar']")).click();
		
	}

	public void informaDataInicialDeclaracaoCumprimentoExigencia(String dataInicialCumprimentoExigenciasInformada) {
		WebElement dataInicialCumprimentoExigencias = WDS.get().findElement(By.xpath("//ngc-formulario[@id='disponibilidade-exigencia']//ngc-campo-data[@id='data-inicial-exigencia']//input"));
		dataInicialCumprimentoExigencias.click();
		dataInicialCumprimentoExigencias.clear();
		dataInicialCumprimentoExigencias.sendKeys(dataInicialCumprimentoExigenciasInformada);
		
	}

	public void informaDataFinalDeclaracaoCumprimentoExigencia(String dataFinalCumprimentoExigenciasInformada) {
		WebElement dataFinalCumprimentoExigencias = WDS.get().findElement(By.xpath("//ngc-formulario[@id='disponibilidade-exigencia']//ngc-campo-data[@id='data-final-exigencia']//input"));
		dataFinalCumprimentoExigencias.click();
		dataFinalCumprimentoExigencias.clear();
		dataFinalCumprimentoExigencias.sendKeys(dataFinalCumprimentoExigenciasInformada);
		
	}
	
	public void solicitarSalvarAlteracaoDeclaracaoCumprimentoExigencia() {
		WDS.get().findElement(By.xpath("//form[@id='disponibilidade-exigencia']//span[contains(text(),'Salvar')]")).click();
		
	}

	public void validarMensagemSucessoAlteracaoPeriodoExigencia(String mensagemSucessoAlteracaoCumpExigencias) {
		
		Assert.assertEquals(mensagemSucessoAlteracaoCumpExigencias, mensagemSucessoAlteracao.getText());
		System.out.println("ALTERAR DISPONIBILIDADE: Mensagem de alteração das datas cumprimento de exigências validada: Liberação salva com sucesso."); 
		
	}




}
