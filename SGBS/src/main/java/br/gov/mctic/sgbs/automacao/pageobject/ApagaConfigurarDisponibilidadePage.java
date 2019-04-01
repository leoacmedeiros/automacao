package br.gov.mctic.sgbs.automacao.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;

public class ApagaConfigurarDisponibilidadePage extends AbstractPageObject{

	WebDriverWait wait;

	@FindBy(xpath = "//button[contains(text(),'Alterar')]")
	private List<WebElement> botaoAlterar;		
	
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement mensagemSucessoRemocaoDisponibilidade;
	
	
	public void solicitarAlterarDisponibilidade() {
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

	public void solicitarApagarDisponibilidade() {
		WDS.get().findElement(By.xpath("//form[@id='disponibilidade']//button[@id='remover']")).click();
		
	}

	public void confirmarRemocaoDisponibilidade() {
		WDS.delay(2000);
		WDS.get().findElement(By.xpath("//md-dialog//md-dialog-actions//button[text()='Sim']")).click();
	}

	public void validarMensagemSucesso(String mensagemRemocaoApresentada) {
		Assert.assertEquals(mensagemRemocaoApresentada, mensagemSucessoRemocaoDisponibilidade.getText());
		System.out.println("APAGAR DISPONIBILIDADE: Mensagem de remoção configurar disponibilidade validada: Operação realizada com sucesso.");
	}

	

}
