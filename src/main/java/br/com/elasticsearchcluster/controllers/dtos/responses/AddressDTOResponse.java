package br.com.elasticsearchcluster.controllers.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOResponse {
    private String id;
    private String cep;
    private String number;
}
