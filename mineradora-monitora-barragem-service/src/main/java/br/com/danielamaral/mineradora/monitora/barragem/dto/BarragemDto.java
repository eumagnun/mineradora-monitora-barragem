package br.com.danielamaral.mineradora.monitora.barragem.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.danielamaral.mineradora.monitora.barragem.model.Barragem;
import br.com.danielamaral.mineradora.monitora.barragem.model.TipoRisco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Barragem")
public class BarragemDto {

	@ApiModelProperty(accessMode = AccessMode.READ_ONLY, required = false)
	private long id;
	
	@ApiModelProperty(name = "nome", required = true)
	private String nome;
	
	@ApiModelProperty(name = "risco", required = true)
	private TipoRisco risco;
	
	@ApiModelProperty(name = "atributosMonitoramento")
	private List<AtributoMonitoramentoDto> atributosMonitoramentoDto;
	
	
	public static BarragemDto parseDto(Barragem model) {
		BarragemDto dto = new BarragemDto();
		dto.setId(model.getId());
		dto.setNome(model.getNome());
		dto.setRisco(model.getRisco());
		
		if(model.getAtributosMonitoramentos() != null) {
			List<AtributoMonitoramentoDto> itens = new ArrayList<>();
			model.getAtributosMonitoramentos().forEach(m -> itens.add(AtributoMonitoramentoDto.parseDto(m)));
			dto.setAtributosMonitoramentoDto(itens);
		}
		return dto;
	}
	
}
