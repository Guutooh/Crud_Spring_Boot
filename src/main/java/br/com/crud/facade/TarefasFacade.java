package br.com.crud.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.crud.dto.TarefaDTO;

@Service
public class TarefasFacade {

	private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

	public TarefaDTO criar(TarefaDTO tarefaDTO) {
		Long Id = tarefas.keySet().size() + 1L;
		tarefaDTO.setId(Id);
		tarefas.put(Id, tarefaDTO);
		return tarefaDTO;
	}

	public TarefaDTO atualizar(TarefaDTO tarefaDTO, Long id) {
		tarefas.put(id, tarefaDTO);
		return tarefaDTO;
	}

	public TarefaDTO getByID (Long id) {
		return tarefas.get(id);
	}
	
	public List<TarefaDTO> getAll(){
		return new ArrayList<>(tarefas.values());
	}
	
	
	public String deletar (Long id) {
		tarefas.remove(id);
		return "Removido com sucesso";
	}
	
}
