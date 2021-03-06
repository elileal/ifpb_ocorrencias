package aplicacao;

import fachada.Fachada;

public class Teste {
	public static void Cadastrar() {
		try {
			System.out.println("Cadastrando Cidades...");
			Fachada.cadastrarCidade("Patos");
			Fachada.cadastrarCidade("Joao Pessoa");
			Fachada.cadastrarCidade("Campina Grande");
			Fachada.cadastrarCidade("Areia");
			Fachada.cadastrarCidade("Camurim");
			System.out.println("Fim do Cadastro de Cidades...");

			System.out.println("Cadastrando Locais...");
			Fachada.cadastrarLocal("Patos", "546127");
			Fachada.cadastrarLocal("Joao Pessoa", "549513");
			Fachada.cadastrarLocal("Campina Grande", "984521");
			Fachada.cadastrarLocal("Campina Grande", "984523");
			Fachada.cadastrarLocal("Areia","123458");
			System.out.println("Fim do Cadastro de Locais...");
			
			System.out.println("Cadastrando Sites...");
			Fachada.cadastrarSite("JURU", "-37.123000, 7.0000", 80.0f, "546127");
			Fachada.cadastrarSite("ALDH", "12.0000, -45.00000", 60.0f, "549513");
			Fachada.cadastrarSite("CAMP", "78.4444, 87.1111", 80f, "984521");
			Fachada.cadastrarSite("AREA", "985.4, 45.223", 60f, "123458");
			System.out.println("Fim do Cadastro de Sites...");
			
			System.out.println("Cadastrando Tecnicos...");
			Fachada.cadastrarTecnico("Joseildo", "7891", "Eletronica");
			Fachada.cadastrarTecnico("Reuelson", "5237891", "Engenheiro");
			Fachada.cadastrarTecnico("Danilo", "5236987", "Telecomunicacoes");
			Fachada.cadastrarTecnico("Gomes", "5236457", "Telecomunicacoes");
			System.out.println("Fim do Cadastro de Tecnicos...");

			System.out.println("Cadastrando Ocorrencias...");
			Fachada.cadastrarOcorrencia("Alarme de Hack", "JURU", "Joseildo");
			Fachada.cadastrarOcorrencia("Temperatura", "CAMP", "Reuelson");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "CAMP", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "CAMP", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "CAMP", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "CAMP", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			Fachada.cadastrarOcorrencia("Alarme de presenca", "ALDH", "Danilo");
			System.out.println("Fim do Cadastro de Ocorrencias...");
			
			System.out.println("Cadastrando Responsaveis...");
			Fachada.cadastrarResponsavel("Eliabe", "83988434480", "546127");
			Fachada.cadastrarResponsavel("Ingrid", "83988434587", "984521");
			System.out.println("Fim do Cadastro de Responsaveis...");
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void Listar() {
		System.out.println(Fachada.listarCidades());
		System.out.println(Fachada.listarLocais());
		System.out.println(Fachada.listarOcorrencia());
		System.out.println(Fachada.listarSite());
		System.out.println(Fachada.listarResponsavel());
		System.out.println(Fachada.listarTecnico());
		System.out.println("Total de Cidades: " + Fachada.totalCidades());
		System.out.println("Total de Sites: " + Fachada.totalSites());
		System.out.println("Total de Tecnicos: " + Fachada.totalTecnicos());
		System.out.println("Total de Ocorrencias: " + Fachada.totalOcorrencias());
		System.out.println("Locais de Campina Grande: " + Fachada.locaisDaCidade("Campina Grande"));
		System.out.println("Sites sem Ocorrencias: " + Fachada.siteSemOcorrencia());
		System.out.println("Tecnicos sem Ocorrencias: " + Fachada.tecnicosSemOcorrencias());
		System.out.println("Cidades sem Locais: " + Fachada.cidadeSemLocal());
		System.out.printf("Percentual de Ocorrencias em CAMP: %.1f%%\n", Fachada.mediaDeOcorrencias("CAMP"));
		System.out.printf("Percentual de Ocorrencias em ALDH: %.1f%%\n", Fachada.mediaDeOcorrencias("ALDH"));
		try {
			System.out.println("Sites atendidos por Danilo " + Fachada.verificaSite("Danilo"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Apagar() {
		try {
			System.out.println("Apagando a Cidade de Joao Pessoa...");
			Fachada.apagarCidade("Joao Pessoa");
			System.out.println("Apagando o Local de numero 546127...");
			Fachada.apagarLocal("546127");
			System.out.println("Apagando o Ocorrencia de numero 3...");
			Fachada.apagarOcorrencia(3);
			System.out.println("Apagando o site JURU...");
			Fachada.apagarSite("JURU");
			System.out.println("Apagando o responsavel Eliabe...");
			Fachada.apagarResponsavel("Eliabe");
			System.out.println("Apagando o tecnico Danilo...");
			Fachada.apagarTecnico("Danilo");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
			
	
	public Teste() {
		Fachada.inicializar();
//		Cadastrar();
		Listar();
//		Apagar();
//		Listar();
		Fachada.finalizar();
		System.out.println("fim do programa");
	}
//  ***********************************************
	public static void main (String[] args)
	//  ***********************************************
	{
		new Teste();
	}
}
