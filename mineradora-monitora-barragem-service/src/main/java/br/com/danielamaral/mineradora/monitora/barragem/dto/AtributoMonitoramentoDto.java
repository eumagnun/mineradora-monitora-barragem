package br.com.danielamaral.mineradora.monitora.barragem.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.danielamaral.mineradora.monitora.barragem.model.AtributoMonitoramento;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "AtributoMonitoramento")
public class AtributoMonitoramentoDto {

	private long id;

	@ApiModelProperty(required = true)
	private String codigo;

	@ApiModelProperty(required = true)
	private String valor;

	@ApiModelProperty(required = true)
	private Date data;
	
	
	
	public static AtributoMonitoramentoDto parseDto(AtributoMonitoramento model) {
		AtributoMonitoramentoDto dto = new AtributoMonitoramentoDto();
		dto.setId(model.getId());
		dto.setCodigo(model.getCodigo());
		dto.setValor(model.getValor());
		dto.setData(model.getData());
		
		return dto;
	}
}
