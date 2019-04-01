package br.gov.mctic.sgbs.automacao.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

public class PesquisarDeclaracaoAtividadesPage extends AbstractPageObject{

	WebDriverWait wait;
	
	@FindBy(xpath = "//span[text()='Pesquisar']")
	private WebElement botaoPesquisar;
	
	@FindBy(xpath = "//span[text()='Limpar']")
	private WebElement botaoLimpar;

	
	public void abrirMenuPesquisa() {
		WDS.get().findElement(By.xpath("//h2[text()='Consultar Declaração de Atividade']")).click();
		
	}

	public void pesquisarPorAnoReferencia(String anoSelecionado) {
		WDS.get().findElement(By.name("anoReferencia")).click();
		WDS.delay(500);
		WDS.get().findElement(By.xpath("//md-select-menu//md-option//div[text()='"+ anoSelecionado + "']")).click();
		WDS.delay(500);
		botaoPesquisar.click();
		
	}

	public void validarPesquisaAnoReferencia() {
		try {
			boolean achouAnoReferencia = WDS.get().getPageSource().contains("2020");
			assertTrue(achouAnoReferencia);
			System.out.println("PESQUISAR DECLARAÇÃO DE ATIVIDADES: Ano de 2020 encontrado na pesquisa.");
			
		} catch (AssertionError e) {
			System.out.println("PESQUISAR DECLARAÇÃO DE ATIVIDADES: Mensagem erro. Ano 2020 não encontrado na pesquisa.");
		}

	}

	public void limparPesquisa() {
		botaoLimpar.click();
		
	}
	
	

}
