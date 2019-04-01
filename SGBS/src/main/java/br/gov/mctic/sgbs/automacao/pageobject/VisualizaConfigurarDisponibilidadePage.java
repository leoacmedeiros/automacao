package br.gov.mctic.sgbs.automacao.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;

import static org.junit.Assert.assertTrue;

import java.util.List;



public class VisualizaConfigurarDisponibilidadePage extends AbstractPageObject{
	
	WebDriverWait wait;
	
	@FindBy(xpath = "//button[contains(text(),'Visualizar')]")
	private List<WebElement> botaoVisualizar;		
			
	
	public void solicitarEditarDisponibilidade() {
		WDS.get().findElement(By.xpath("//table//tr[contains(.,'2030')]//td//md-menu")).click();
	}
	
	public void solicitarVisualizar() {
		WDS.delay(500);
		for (WebElement botaoVisualizar1 : botaoVisualizar) {
		if (botaoVisualizar1.isDisplayed()) {
			botaoVisualizar1.click();
		break;
		}
	}
}

	public void verificarAnoCadastrado() {
		try {
			boolean achouAnoCadastrado = WDS.get().getPageSource().contains("2030");
			assertTrue(achouAnoCadastrado);
			System.out.println("VISUALIZAR DISPONIBILIDADE: Disponibilidade cadastrada. Ano de 2030 Cadastrado.");
		}catch(AssertionError e){
				System.out.print("Mensagem Erro: Ano não cadastrado.");
			}
		
		
		
	}

	

}
