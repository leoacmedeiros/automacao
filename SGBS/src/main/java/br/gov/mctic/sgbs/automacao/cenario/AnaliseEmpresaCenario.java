package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;

import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.AnaliseEmpresaPage;

public class AnaliseEmpresaCenario extends AbstractCenario {

    @Test
    public void acessarAnaliseEmpresa() {
        acessarMenu("Empresa", "Analisar");
        Em(AnaliseEmpresaPage.class).exportarPDF();
    }
}
