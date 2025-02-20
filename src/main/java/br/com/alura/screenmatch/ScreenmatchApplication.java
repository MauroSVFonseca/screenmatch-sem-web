package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto spring sem web");

		//ConsumoApi consumoApi = new ConsumoApi();
		var consumoApi = new ConsumoApi();
		//var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&Season=1&apikey=88065070");
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=88065070");
		//System.out.println(json);
		//var json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		System.out.println(">>>>>>>>>>>>>>>>>>>  f i m  <<<<<<<<<<<<<<<<<<<<<<<<<<<<");

	}
}
