package br.com.alura.leilao.teste;


import org.junit.Assert;
import org.junit.Test;

import br.com.alura.leilao.dominio.Lance;
import br.com.alura.leilao.dominio.Leilao;
import br.com.alura.leilao.dominio.Usuario;
import br.com.alura.leilao.servico.Avaliador;

public class TesteAvaliador {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		// parte 1 : montar cen�rio
		
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		// parte 2 : a��o
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		
		// parte 3 : valida��o (manual)
		
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}

}
