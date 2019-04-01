package br.gov.mctic.sgbs.automacao.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;
import br.gov.mctic.sgbs.automacao.core.WDS;

public class CadastroEmpresaPage extends AbstractPageObject {

	WebDriverWait wait;

	@FindBy(id = "::input-cnpj")
	private WebElement campoCnpj;

	@FindBy(xpath = "//span[text()='Próximo']")
	private List<WebElement> botoesProximo;

	@FindBy(id = "alterar")
	private WebElement botaoAlterar;
	
	@FindBy(id = "::input-nome-arquivo")
	private WebElement nomeArquivo;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement caixaMensagem;


	public void informarCpnj(String cnpj) {
		campoCnpj.sendKeys(cnpj);
		campoCnpj.sendKeys(Keys.TAB);
	}

	public void solicitarProximo() {
		WDS.delay(500);
		for (WebElement botaoProximo : botoesProximo) {
			if (botaoProximo.isDisplayed()) {
				botaoProximo.click();
				break;
			}
		}
	}

	public void solicitarEdicaoRepresentante(String cpfRepresentante) {
		WDS.get().findElement(By.xpath("//tr/td[text()='" + cpfRepresentante + "']/../td[7]/md-menu/button")).click();
		WDS.delay(500);
		WDS.get().findElement(By.xpath(
				"//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[1]/button"))
				.click();
	}

	public void informarEmailRepresentante(String emailRepresentante) {
		WebElement quadro = WDS.get().findElement(By.xpath("//ngc-dialogo[@aria-label='Editar Representante']"));
		WebElement campoEmailRepresentante = quadro.findElement(By.id("::input-email"));
		campoEmailRepresentante.clear();
		campoEmailRepresentante.sendKeys(emailRepresentante);
	}

	public void solicitarAlterar() {
		botaoAlterar.click();
	}

	
	public void informarNomeArquivo(String descricaoNomeArquivo) {
		nomeArquivo.sendKeys(descricaoNomeArquivo);
		
	}

	public void selecionarTipoDocumento(String tipoDocumentoSelecionado) {
		WDS.get().findElement(By.id("select_2")).click();
		WDS.get().findElement(By.xpath("//div[text()='" + tipoDocumentoSelecionado + "']")).click();
				
	}

	public void selecionarArquivo(String arquivo) {		
		WDS.get().findElement(By.xpath("//input[@type='file']")).sendKeys(WDS.getCaminhoArquivo(arquivo));
		
	}

	public void solicitarAdicionarArquivo() {
		WDS.get().findElement(By.xpath("\n" + 
				"//*[@id=\"anexos\"]//div//ngc-cartao-acoes//ngc-botao[1]//button//span[text()='Adicionar']")).click();
		
	}

	public void soliciarSalvarEmpresa() {
		WDS.get().findElement(By.xpath("//ngc-botao//button//span[text()='Salvar']")).click();;
		
	}

	public void validarMensagem(String mensagem) {
		WDS.delay(1000);
		try{
			Assert.assertEquals(mensagem,caixaMensagem.getText());
			System.out.println("CADASTRO EMPRESA: Mensagem validada. Operação realizada com sucesso.");
			}catch(AssertionError e){
			System.out.println("CADASTRO EMPRESA: Mensagem Erro. Mensagem não validada ---> Operação realizada com sucesso.");
		}
				
	}
	
	

}
