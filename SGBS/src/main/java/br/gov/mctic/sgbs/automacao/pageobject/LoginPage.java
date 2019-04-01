package br.gov.mctic.sgbs.automacao.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;

public class LoginPage extends AbstractPageObject {

    @FindBy(id = "username")
    private WebElement campoUsuario;

    @FindBy(id = "password")
    private WebElement campoSenha;

    @FindBy(name = "efetuar-login")
    private WebElement botaoEntrar;

    public void informarUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);
    }

    public void informarSenha(String senha) {
        campoSenha.sendKeys(senha);
    }

    public void solicitarLogin() {
        botaoEntrar.click();
    }

}
