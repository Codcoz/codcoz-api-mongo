package org.example.mongocrud.controller.empresa;

import org.example.mongocrud.model.empresa.Empresa;
import org.example.mongocrud.service.empresa.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController (EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll(){
        List<Empresa> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable String id){
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<Empresa> insert(@RequestBody Empresa empresa){
        Empresa empresaInserida = empresaService.insert(empresa);
        return ResponseEntity.ok(empresaInserida);
    }
}
