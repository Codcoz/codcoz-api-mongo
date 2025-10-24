package org.example.mongocrud.dto.empresa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EmpresaResponseDTO {
    private Long id;
    private String nome;
    private String sigla;
    private String status;
}