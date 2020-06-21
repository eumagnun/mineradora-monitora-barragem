package br.com.danielamaral.mineradora.monitora.barragem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.danielamaral.mineradora.monitora.barragem.dto.AtributoMonitoramentoDto;
import br.com.danielamaral.mineradora.monitora.barragem.dto.BarragemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Barragem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private TipoRisco risco;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<AtributoMonitoramento> atributosMonitoramentos;
	
	
	public static Barragem parseModel(BarragemDto dto) {
		Barragem  model= new Barragem();
		model.setId(dto.getId());
		model.setNome(dto.getNome());
		model.setRisco(dto.getRisco());
		
		if(dto.getAtributosMonitoramentoDto() != null) {
			List<AtributoMonitoramento> itens = new ArrayList<>();
			dto.getAtributosMonitoramentoDto().forEach(m -> itens.add(AtributoMonitoramento.parseModel(m)));
			model.setAtributosMonitoramentos(itens);
		}
		return model;
	}
	
	
}
