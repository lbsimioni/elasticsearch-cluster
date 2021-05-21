package br.com.elasticsearchcluster.gateway.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "address")
public class AddressDocument {
    @Id
    private String id;
    private String cep;
    private String number;
}
