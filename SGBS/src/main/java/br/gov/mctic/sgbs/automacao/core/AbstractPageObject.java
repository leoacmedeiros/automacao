package br.gov.mctic.sgbs.automacao.core;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractPageObject {


    @FindBy(id="msg")
    private WebElement campoMensagem;
    
    public void exibeMensagem(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, campoMensagem.getText());
    }
}
