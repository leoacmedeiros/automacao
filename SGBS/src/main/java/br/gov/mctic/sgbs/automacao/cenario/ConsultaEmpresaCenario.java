package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;

import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.core.WDS;
import br.gov.mctic.sgbs.automacao.pageobject.ConsultaEmpresaPage;

public class ConsultaEmpresaCenario extends AbstractCenario {

    @Test
    public void ct001_consultarEmpresa() {
        acessarMenu("Empresa", "Analisar");
        Em(ConsultaEmpresaPage.class).solicitarPesquisarEmpresaCnpj();
        aguardarCarregamento();
        Em(ConsultaEmpresaPage.class).validarResultadoPesquisaEmpresa();
        aguardarCarregamento();
        Em(ConsultaEmpresaPage.class).clicarBotaoAcoes();
        aguardarCarregamento();
        Em(ConsultaEmpresaPage.class).solicitarDetalharEmpresa();

    }
}
