package factory;

import iphone.Iphone;

public class Fabrica {
	public static void main(String[] args) {
		Iphone iphone = new Iphone();
		
		System.out.println("Iniciando a parte do Browser");
		//Browser
		iphone.exibirPagina("https://www.google.com/");
		iphone.adicionarNovaAba();
		iphone.atualizarPagina();
		
		System.out.println("");
		System.out.println("Iniciando a parte do Phone");
		//Phone
		iphone.ligar(17111111111L);
		iphone.atender();
		iphone.iniciarCorreioVoz();
		
		System.out.println("");
		System.out.println("Iniciando a parte do Player");
		//Player
		iphone.tocar();
		iphone.pausar();
		iphone.selecionarMusica("AC/DC - Thunderstruck");
	}
}
