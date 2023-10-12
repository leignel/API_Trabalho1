package com.residencia.academia.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.academia.entities.Telefone;
import com.residencia.academia.repositories.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepo;
	
	//recuperar todos os telefone
	public List<Telefone> listarTelefones(){
		return telefoneRepo.findAll();
	}
	
	//recuperar um telefone pela sua chave primária
	public Telefone buscarTelefonePorId(Integer id){
		return telefoneRepo.findById(id).orElse(null);
	}
	
	//salvar um novo telefone
	public Telefone salvarTelefone(Telefone telefone) {
		return telefoneRepo.save(telefone);
	}
	
	//atualizar um determinado telefone
	public Telefone atualizarTelefone(Telefone telefone) {
		return telefoneRepo.save(telefone);
	}
	
	//deletar um determinado telefone
	public Boolean deletarTelefone(Telefone telefone) {
		if(telefone == null)
			return false;
		
		Telefone telefoneExistente = buscarTelefonePorId(telefone.getIdTelefone());
		
		if(telefoneExistente == null)
			return false;
		
		telefoneRepo.delete(telefone);
		
		Telefone telefoneContinuaExistindo =
				buscarTelefonePorId(telefone.getIdTelefone());
		
		if(telefoneContinuaExistindo != null)
			return false;
		
		return true;
	}
}
