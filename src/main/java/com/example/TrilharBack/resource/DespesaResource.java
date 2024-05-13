
package com.example.TrilharBack.resource;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.TrilharBack.models.Despesa;
import com.example.TrilharBack.services.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaResource {

    @Autowired
    private DespesaService despesaService;

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> findById(@PathVariable Long id){
        Despesa obj = despesaService.buscarDespesa(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Despesa obj){
        Despesa despesaCriada = despesaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(despesaCriada.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Despesa obj, @PathVariable Long id){
        obj.setId(id);
        despesaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        despesaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
