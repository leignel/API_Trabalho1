package com.residencia.academia.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.academia.entities.Instrutor;
import com.residencia.academia.repositories.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepo;
	
	//recuperar todos os instrutores
	public List<Instrutor> listarInstrutores(){
		return instrutorRepo.findAll();
	}
	
	//recuperar um instrutor pela sua chave primária
	public Instrutor buscarInstrutorPorId(Integer id){
		return instrutorRepo.findById(id).orElse(null);
	}
	
	//salvar um novo instrutor
	public Instrutor salvarInstrutor(Instrutor instrutor) {
		return instrutorRepo.save(instrutor);
	}
	
	//atualizar um determinado instrutor
	public Instrutor atualizarInstrutor(Instrutor instrutor) {
		return instrutorRepo.save(instrutor);
	}
	
	//deletar um determinado instrutor
	public Boolean deletarInstrutor(Instrutor instrutor) {
		if(instrutor == null)
			return false;
		
		Instrutor instrutorExistente = buscarInstrutorPorId(instrutor.getIdInstrutor());
		
		if(instrutorExistente == null)
			return false;
		
		instrutorRepo.delete(instrutor);
		
		Instrutor instrutorContinuaExistindo =
				buscarInstrutorPorId(instrutor.getIdInstrutor());
		
		if(instrutorContinuaExistindo != null)
			return false;
		
		return true;
	}

	public boolean existeInstrutor(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
