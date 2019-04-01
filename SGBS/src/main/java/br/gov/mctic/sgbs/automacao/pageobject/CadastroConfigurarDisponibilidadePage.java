package br.gov.mctic.sgbs.automacao.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;


public class CadastroConfigurarDisponibilidadePage extends AbstractPageObject {

	WebDriverWait wait;


	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement mensagemSucessoCadastro;
	
	
	public void solicitarLiberarCadastro() {
		WDS.get().findElement(By.xpath("//ngc-botao//button//span[text()='Liberar Cadastro']")).click();
	}


	public void informarDataInicial(String dataInicialInformada) {
		WebElement dataInicial = WDS.get().findElement(By.xpath("//*[@id='data-inicial']//md-input-container//md-datepicker//div//input"));
		dataInicial.click();
		dataInicial.sendKeys(dataInicialInformada);
		
	}


	public void informarDataFinal(String dataFinalInformada) {
		WebElement dataFinal = WDS.get().findElement(By.xpath("//*[@id='data-final']//md-input-container//md-datepicker//div//input"));
		dataFinal.click();
		dataFinal.sendKeys(dataFinalInformada);
		
	}
	
	public void selecionarTipoDeclaracao(String tipoDeclaracaoSelecionada) {
		WDS.get().findElement(By.xpath("//form//div//ngc-combobox//md-input-container//md-select")).click();
		WDS.delay(1000);
		WDS.get().findElement(By.xpath("//div[text()='" + tipoDeclaracaoSelecionada + "']")).click();
				
	}

	public void validarMensagemCampoObrigatorioAnoReferencia(String mensagemCampoObrigatorioAnoReferencia) {
		
		WebElement anoReferencia = WDS.get().findElement(By.id("::input-ano-referencia"));
		anoReferencia.click();
		
		WebElement dataInicial = WDS.get().findElement(By.xpath("//*[@id='data-inicial']//md-input-container//md-datepicker//div//input"));
		dataInicial.click();		
		
		WebElement caixaMensagemCampoObrigatorioAnoReferencia = WDS.get().findElement(By.xpath("//*[@id='ano-referencia']//div//div"));		
		Assert.assertEquals(mensagemCampoObrigatorioAnoReferencia, caixaMensagemCampoObrigatorioAnoReferencia.getText());
		System.out.println("CADASTRAR DISPONIBILIDADE: Mensagem de obrigatoriedade Ano de Referência validada: O campo é de preenchimento obrigatório");
	}
	
	
	
	public void informarAnoReferencia(String anoInformado) {
		WebElement anoReferencia = WDS.get().findElement(By.id("::input-ano-referencia"));
		anoReferencia.click();
		anoReferencia.sendKeys(anoInformado);
		
	}


	public void solicitarLiberarDisponibilidade() {
		WDS.get().findElement(By.xpath("//ngc-botao//button//span[contains(.,'Liberar')]")).click();
		
	}

	
	public void validarMensagemSucessoLiberar(String mensagemSucessoLiberarApresentada) {
		Assert.assertEquals(mensagemSucessoLiberarApresentada, mensagemSucessoCadastro.getText());
		System.out.println("CADASTRAR DISPONIBILIDADE: Mensagem liberação cadastrada validada: Liberação salva com sucesso.");
		
		
	}

	public void informarDataInicialDeclaracoesCumprimentoExigencias(String dataInicialCumprimentoExigenciasInformada) {
			
		WebElement dataInicialCumprimentoExigencias = WDS.get().findElement(By.xpath("//ngc-formulario[@id='disponibilidade-exigencia']//ngc-campo-data[@id='data-inicial-exigencia']//input"));
		dataInicialCumprimentoExigencias.click();
		dataInicialCumprimentoExigencias.sendKeys(dataInicialCumprimentoExigenciasInformada);
		
	}


	public void informarDataFinalDeclaracoesCumprimentoExigencias(String dataFinalCumprimentoExigenciasInformada) {
		WebElement dataFinalCumprimentoExigencias = WDS.get().findElement(By.xpath("//ngc-formulario[@id='disponibilidade-exigencia']//ngc-campo-data[@id='data-final-exigencia']//input"));
		dataFinalCumprimentoExigencias.click();
		dataFinalCumprimentoExigencias.sendKeys(dataFinalCumprimentoExigenciasInformada);
		
	}


	public void solicitarLiberarDeclaracoesCumprimentoExigencias() {
		WDS.get().findElement(By.xpath("//form[@id='disponibilidade-exigencia']//ngc-botao//button[@class='md-raised md-primary md-hue-2 md-button']//span[text()='Liberar']")).click();
		}


	public void validarMensagemSucessoPeriodoExigencias(String mensagemSucessoPeriodoExigenciasApresentada) {
		Assert.assertEquals(mensagemSucessoPeriodoExigenciasApresentada, mensagemSucessoCadastro.getText());
		System.out.println("CADASTRAR DISPONIBILIDADE: Mensagem Período de exigências validada: Período de exigências salvo com sucesso!");
		
	}


	public void validarDisponibilidadeCadastrada() {
		boolean achouDisponibilidadeCadastrada = WDS.get().getPageSource().contains("2030");
		assertTrue(achouDisponibilidadeCadastrada);
		System.out.println("CADASTRAR DISPONIBILIDADE: Disponibilidade cadastrada. Ano de 2030 Cadastrado.");
		
	}

	

	


	
}
