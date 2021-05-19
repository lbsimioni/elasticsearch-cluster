package br.com.elasticsearchcluster.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTORequest {
    private AddressDTORequest address;
    private String type;
    private Double cost;
}
