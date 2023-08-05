package iphone;

import browser.Browser;
import phone.Phone;
import player.Player;

public class Iphone implements Browser, Phone, Player {

	@Override
	public void exibirPagina(String url) {
		System.out.println("Acessando a p�gina: " + url);
		
	}

	@Override
	public void adicionarNovaAba() {
		System.out.println("Adicionando nova aba.");
		
	}

	@Override
	public void atualizarPagina() {
		System.out.println("Atualizando a p�gina.");
		
	}

	@Override
	public void ligar(Long numero) {
		System.out.println("Ligando para o n�mero: " + numero);
		
	}

	@Override
	public void atender() {
		System.out.println("Atendendo.");
		
	}

	@Override
	public void iniciarCorreioVoz() {
		System.out.println("Iniciando correio de voz.");
		
	}

	@Override
	public void tocar() {
		System.out.println("Tocando m�sica.");
		
	}

	@Override
	public void pausar() {
		System.out.println("Pausando m�sica.");
		
	}

	@Override
	public void selecionarMusica(String musica) {
		System.out.println("Selecionando a m�sica: " + musica);
		
	}
}
