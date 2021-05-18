package br.com.elasticsearchcluster.gateway.documents;

import br.com.elasticsearchcluster.gateway.enums.PropertyTypeDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@Document(indexName = "properties")
public class PropertyDocument {
    @Id
    private String id;

    @Field(type = FieldType.Nested, includeInParent = true)
    private AddressDocument address;

    @Field(type = FieldType.Text)
    private PropertyTypeDocument type;

    private BigDecimal cost;
}
