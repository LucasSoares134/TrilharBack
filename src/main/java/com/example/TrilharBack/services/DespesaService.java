package com.example.TrilharBack.services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TrilharBack.models.Despesa;
import com.example.TrilharBack.repository.DespesaRepository;

@Service
public class DespesaService {
    
    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa buscarDespesa(Long id) {
        Optional<Despesa> despesaOptional = despesaRepository.findById(id);
        return despesaOptional.orElseThrow(() -> new RuntimeException("Despesa não encontrada! Id: " + id));
    }

    public Despesa create(Despesa obj) {
        return despesaRepository.save(obj);
    }

    public Despesa update(Despesa obj) {
        Despesa despesaExistente = buscarDespesa(obj.getId());
        despesaExistente.setDescricao(obj.getDescricao());
        return despesaRepository.save(despesaExistente);
    }

    public void delete(Long id) {
        Despesa despesa = buscarDespesa(id);
        try {
            despesaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir a despesa, pois há entidades relacionadas!", e);
        }
    }
}
