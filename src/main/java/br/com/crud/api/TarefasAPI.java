package br.com.crud.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.crud.dto.TarefaDTO;
import br.com.crud.facade.TarefasFacade;

@Controller
@RequestMapping(value ="/tarefas", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
public class TarefasAPI {

	@Autowired
	private TarefasFacade tarefasFacade;
	
	@PostMapping
	@ResponseBody
	public TarefaDTO criar (@RequestBody TarefaDTO tarefaDTO) {
		return tarefasFacade.criar(tarefaDTO);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public TarefaDTO atualizar(@PathVariable("id") Long id, @RequestBody TarefaDTO tarefaDTO){
		return tarefasFacade.atualizar(tarefaDTO, id);
	}
	
	@GetMapping
	@ResponseBody
	public List<TarefaDTO> getAll(){
		return tarefasFacade.getAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletar (@PathVariable("id") Long id) {
		return tarefasFacade.deletar(id);
	}
	
	
}
