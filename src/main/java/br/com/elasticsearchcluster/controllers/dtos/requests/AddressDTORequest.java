package br.com.elasticsearchcluster.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTORequest {
    @NotBlank
    private String cep;
    @NotBlank
    private String number;
}
