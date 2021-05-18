package br.com.elasticsearchcluster.gateway.repositories;

import br.com.elasticsearchcluster.gateway.documents.PropertyDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDocumentRepository extends ElasticsearchRepository<PropertyDocument, String> {
}
