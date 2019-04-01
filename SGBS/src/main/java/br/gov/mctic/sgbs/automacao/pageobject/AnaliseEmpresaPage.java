package br.gov.mctic.sgbs.automacao.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.mctic.sgbs.automacao.core.AbstractPageObject;

public class AnaliseEmpresaPage extends AbstractPageObject {

    @FindBy(xpath = "//span[text()='Exportar PDF']")
    private WebElement botaoExportarPDF;

    public void exportarPDF() {
        botaoExportarPDF.click();
    }

}
