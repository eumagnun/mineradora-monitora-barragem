package br.com.danielamaral.mineradora.monitora.barragem.bussiness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.monitora.barragem.model.Barragem;
import br.com.danielamaral.mineradora.monitora.barragem.model.TipoRisco;
import br.com.danielamaral.mineradora.monitora.barragem.repository.BarragemRepository;

@Service
public class BarragemBussiness {
	
	@Autowired
	BarragemRepository barragemRepository;

	public Barragem atualizarRiscoBarragem(long idBarragem, TipoRisco risco) {
		Optional<Barragem> barragem = barragemRepository.findById(idBarragem);
		barragem.get().setRisco(risco);
		barragemRepository.save(barragem.get());
		return  barragem.get();
	}
}
