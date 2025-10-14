package org.example.mongocrud.service.empresa;

import org.example.mongocrud.model.empresa.Empresa;
import org.example.mongocrud.repository.empresa.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(String id) {
        return empresaRepository.findById(id).get();
    }

    public Empresa insert(Empresa empresa) {
        return empresaRepository.insert(empresa);
    }
}
