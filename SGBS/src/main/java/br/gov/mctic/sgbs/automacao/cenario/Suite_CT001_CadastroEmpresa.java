package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CadastroEmpresaCenario.class, ConsultaEmpresaCenario.class, CadastroEmpresaNaoAprovarCenario.class })
public class Suite_CT001_CadastroEmpresa {

}
