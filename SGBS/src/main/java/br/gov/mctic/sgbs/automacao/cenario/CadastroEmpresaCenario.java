package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.Test;

import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.pageobject.CadastroEmpresaPage;

public class CadastroEmpresaCenario extends AbstractCenario {

    @Test
    public void ct001_cadastrarEmpresa() {
        acessarMenu("Empresa", "Cadastrar");
        Em(CadastroEmpresaPage.class).informarCpnj("01.844.555/0005-06");
        aguardarCarregamento();
        Em(CadastroEmpresaPage.class).solicitarProximo();
        Em(CadastroEmpresaPage.class).solicitarEdicaoRepresentante("010.912.459-67");
        Em(CadastroEmpresaPage.class).informarEmailRepresentante("roberto.ungarelli@gmail.com");
        Em(CadastroEmpresaPage.class).solicitarAlterar();
        aguardarCarregamento();
        Em(CadastroEmpresaPage.class).solicitarEdicaoRepresentante("002.747.501-80");
        Em(CadastroEmpresaPage.class).informarEmailRepresentante("roberto.ungarelli@gmail.com");
        Em(CadastroEmpresaPage.class).solicitarAlterar();
        aguardarCarregamento();
        Em(CadastroEmpresaPage.class).solicitarProximo();
        Em(CadastroEmpresaPage.class).informarNomeArquivo("Documento teste 1");
        aguardarCarregamento();
        Em(CadastroEmpresaPage.class).selecionarTipoDocumento("Comprovante de Inscrição RFB");
        aguardarCarregamento();
        Em(CadastroEmpresaPage.class).selecionarArquivo("arquivo_ct001_001.pdf");
        Em(CadastroEmpresaPage.class).solicitarAdicionarArquivo();
        aguardarCarregamento();
        Em(CadastroEmpresaPage.class).soliciarSalvarEmpresa();
        Em(CadastroEmpresaPage.class).validarMensagem("Operação realizada com sucesso.");
    }

}
