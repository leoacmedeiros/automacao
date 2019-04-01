package br.gov.mctic.sgbs.automacao.cenario;

import br.gov.mctic.sgbs.automacao.core.AbstractCenario;
import br.gov.mctic.sgbs.automacao.core.PropriedadeUtils;
import br.gov.mctic.sgbs.automacao.pageobject.LoginPage;

public class LoginCenario extends AbstractCenario {

    public void realizarLogin() {
        Em(LoginPage.class).informarUsuario(PropriedadeUtils.get("usuario"));
        Em(LoginPage.class).informarSenha(PropriedadeUtils.get("senha"));
        Em(LoginPage.class).solicitarLogin();
    }

}
