package br.com.elasticsearchcluster.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTORequest {
    @Valid
    private AddressDTORequest address;
    @NotEmpty
    private String type;
    private Double cost;
}
