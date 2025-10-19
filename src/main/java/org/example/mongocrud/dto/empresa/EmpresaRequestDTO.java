package org.example.mongocrud.dto.empresa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.mongocrud.validation.OnCreate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmpresaRequestDTO {
    @NotBlank(message = "O campo 'nome' é obrigatório", groups = OnCreate.class)
    private String nome;
    @NotBlank(message = "O campo 'sigla' é obrigatório", groups = OnCreate.class)
    private String sigla;
    private String status;
}