package br.gov.mctic.sgbs.automacao.cenario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses

({CadastroConfigurarDisponibilidadeCenario.class, 
	VisualizaConfigurarDisponibilidadeCenario.class,
	AlteraConfigurarDisponibilidadeCenario.class, 
	ApagaConfigurarDisponibilidadeCenario.class, 
	})

public class Suite_CT008_ConfigurarDisponibilidade {

}
