package br.com.elasticsearchcluster.controllers.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyResponseDTO {
    private String id;
    private AddressResponseDTO address;
    private String type;
    private BigDecimal cost;
}
