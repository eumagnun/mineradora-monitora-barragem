package br.com.danielamaral.mineradora.monitora.barragem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielamaral.mineradora.monitora.barragem.model.Barragem;

public interface BarragemRepository   extends JpaRepository<Barragem, Long> {

}
