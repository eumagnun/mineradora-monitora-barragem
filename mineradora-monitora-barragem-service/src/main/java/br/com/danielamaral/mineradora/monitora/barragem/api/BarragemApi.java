package br.com.danielamaral.mineradora.monitora.barragem.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielamaral.mineradora.monitora.barragem.bussiness.BarragemBussiness;
import br.com.danielamaral.mineradora.monitora.barragem.dto.BarragemDto;
import br.com.danielamaral.mineradora.monitora.barragem.model.Barragem;
import br.com.danielamaral.mineradora.monitora.barragem.model.TipoRisco;
import br.com.danielamaral.mineradora.monitora.barragem.repository.BarragemRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/barragem")
public class BarragemApi {

	
	@Autowired
	private BarragemRepository barragemRepository;
	
	@Autowired
	private BarragemBussiness barragemBussiness;
	
	
	@ApiOperation(value = "Cadastrar Barragem")
	@PostMapping(consumes = "application/json",produces = "application/json")
	public BarragemDto cadastrarManutençao(@RequestBody BarragemDto barragemDto) {
		return BarragemDto.parseDto(barragemRepository.save(Barragem.parseModel(barragemDto)));
	}
	
	
	
	@ApiOperation(value = "pesquisar barragens")
	@GetMapping(produces = "application/json")
	public List<BarragemDto> pesquisarBarragens() {
		List<BarragemDto> list = new ArrayList<>();
		
		barragemRepository.findAll().forEach(b -> list.add(BarragemDto.parseDto(b)));
		return list;
	}
	
	
	@ApiOperation(value = "consultar barragem por id")
	@GetMapping(value = "/{id}", produces = "application/json")
	public BarragemDto consultar(@PathVariable Long id) {
		return BarragemDto.parseDto(barragemRepository.findById(id).get());
	}
	
	
	@ApiOperation(value = "atualizar situação de risco barragem")
	@PutMapping(value = "/{id}/risco/{risco}", produces = "application/json")
	public BarragemDto atualizar(@PathVariable Long id, @PathVariable TipoRisco risco) {
		BarragemDto barragemDto = BarragemDto.parseDto(barragemBussiness.atualizarRiscoBarragem(id, risco));
		return barragemDto;
	}
	
}
