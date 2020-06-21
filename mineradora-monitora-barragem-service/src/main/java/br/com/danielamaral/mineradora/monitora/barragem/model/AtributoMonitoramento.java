package br.com.danielamaral.mineradora.monitora.barragem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.danielamaral.mineradora.monitora.barragem.dto.AtributoMonitoramentoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AtributoMonitoramento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String codigo;

	private String valor;

	private Date data;

	public static AtributoMonitoramento parseModel(AtributoMonitoramentoDto dto) {
		AtributoMonitoramento model = new AtributoMonitoramento();
		model.setId(dto.getId());
		model.setCodigo(dto.getCodigo());
		model.setValor(dto.getValor());
		model.setData(dto.getData());
		return model;
	}

}
