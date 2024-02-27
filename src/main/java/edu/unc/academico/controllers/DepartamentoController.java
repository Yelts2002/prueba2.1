package edu.unc.academico.controllers;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.services.DepartamentoService;

@RestController
@RequestMapping("api/v1/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService dptoService;
	
	
	@GetMapping
	public List<Departamento> listarDepartamentos() {
		return dptoService.listaDto();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorDpto(@PathVariable Long id) {
		Optional<Departamento> dtoOptional = dptoService.buscarPorIdDpto(id);
		if(dtoOptional.isPresent()) {
			return ResponseEntity.ok(dtoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	private ResponseEntity<?> crearDpto(@RequestBody Departamento dpto) {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.CREATED).body(dptoService)
	}
	
}
