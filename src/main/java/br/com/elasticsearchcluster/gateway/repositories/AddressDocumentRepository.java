package br.com.elasticsearchcluster.gateway.repositories;

import br.com.elasticsearchcluster.gateway.documents.AddressDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDocumentRepository extends ElasticsearchRepository<AddressDocument, String> {
}
