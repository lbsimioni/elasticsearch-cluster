package br.com.elasticsearchcluster.controllers.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTOResponse {
    private String id;
    private AddressDTOResponse address;
    private String type;
    private BigDecimal cost;
}
