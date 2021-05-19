package br.com.elasticsearchcluster.controllers.dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTORequest {
    private String cep;
    private String number;
}