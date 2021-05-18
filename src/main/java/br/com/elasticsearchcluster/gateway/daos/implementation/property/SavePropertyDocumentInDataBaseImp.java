package br.com.elasticsearchcluster.gateway.daos.implementation.property;

import br.com.elasticsearchcluster.gateway.adapters.PropertyDocumentAdapter;
import br.com.elasticsearchcluster.gateway.daos.interfaces.property.SavePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.gateway.repositories.PropertyDocumentRepository;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SavePropertyDocumentInDataBaseImp implements SavePropertyDocumentInDataBase {

    private final PropertyDocumentRepository repository;

    @Override
    public PropertyModel execute(PropertyModel property) {
        return PropertyDocumentAdapter.toModel(repository.save(PropertyDocumentAdapter.toDocument(property)));
    }
}
