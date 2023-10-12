package com.residencia.academia.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.academia.entities.Turma;
import com.residencia.academia.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepo;
	
	//recuperar todos os turma
	public List<Turma> listarTurmas(){
		return turmaRepo.findAll();
	}
	
	//recuperar um turma pela sua chave primária
	public Turma buscarTurmaPorId(Integer id){
		return turmaRepo.findById(id).orElse(null);
	}
	
	//salvar um novo turma
	public Turma salvarTurma(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	//atualizar um determinado turma
	public Turma atualizarTurma(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	//deletar um determinado turma
	public Boolean deletarTurma(Turma turma) {
		if(turma == null)
			return false;
		
		Turma turmaExistente = buscarTurmaPorId(turma.getIdTurma());
		
		if(turmaExistente == null)
			return false;
		
		turmaRepo.delete(turma);
		
		Turma turmaContinuaExistindo =
				buscarTurmaPorId(turma.getIdTurma());
		
		if(turmaContinuaExistindo != null)
			return false;
		
		return true;
	}
}
