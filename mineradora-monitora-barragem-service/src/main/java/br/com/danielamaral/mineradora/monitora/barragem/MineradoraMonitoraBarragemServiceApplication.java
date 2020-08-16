package br.com.danielamaral.mineradora.monitora.barragem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MineradoraMonitoraBarragemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineradoraMonitoraBarragemServiceApplication.class, args);
	}

}
