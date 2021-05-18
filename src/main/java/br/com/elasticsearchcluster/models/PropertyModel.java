package br.com.elasticsearchcluster.models;

import br.com.elasticsearchcluster.models.enums.PropertyTypeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyModel {
    private String id;
    private AddressModel address;
    private PropertyTypeModel type;
    private BigDecimal cost;
}
