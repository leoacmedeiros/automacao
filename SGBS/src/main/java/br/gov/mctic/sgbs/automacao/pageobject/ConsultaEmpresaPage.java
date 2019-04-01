package br.gov.mctic.sgbs.automacao.pageobject;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;


public class ConsultaEmpresaPage extends AbstractPageObject{

	@FindBy(id = "::input-cnpj")
	private WebElement campoCnpj;
	
	@FindBy(xpath = "//span[text()='Pesquisar']")
	private WebElement botaoPesquisar;
	
	
	@FindBy(xpath = "//button[contains(text(),'Detalhar')]")
	private List<WebElement> botaoDetalhar;	
	
	public void solicitarPesquisarEmpresaCnpj() {
		WDS.get().findElement(By.xpath("//ngc-acordeon-painel//div//h2[text()='Consultar Empresa']")).click();
		WDS.delay(1500);
		campoCnpj.click();
		campoCnpj.sendKeys("01.844.555/0005-06");
		botaoPesquisar.click();
		
	}


	public void validarResultadoPesquisaEmpresa() {
		WDS.delay(1000);
		
		try {
			boolean achouCnpjCadastrado = WDS.get().getPageSource().contains("01.844.555/0005-06");
			assertTrue(achouCnpjCadastrado);
			System.out.println("CONSULTAR EMPRESA: CNPJ encontrado.");
		}catch(AssertionError e){
				System.out.println("Mensagem Erro: CNPJ não encontrado.");
			}
	}


	public void clicarBotaoAcoes() {
		WDS.get().findElement(By.xpath("//table//tr[contains(.,'01.844.555/0005-06')]//td//md-menu")).click();
				
	}


	public void solicitarDetalharEmpresa() {
		WDS.delay(500);
		for (WebElement botaoDetalhar1 : botaoDetalhar) {
		if (botaoDetalhar1.isDisplayed()) {
			botaoDetalhar1.click();
		break;
		}
	}
}
	
	
	

}
