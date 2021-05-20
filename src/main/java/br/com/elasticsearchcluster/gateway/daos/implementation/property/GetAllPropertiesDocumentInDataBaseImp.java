package br.com.elasticsearchcluster.gateway.daos.implementation.property;

import br.com.elasticsearchcluster.gateway.adapters.PropertyDocumentAdapter;
import br.com.elasticsearchcluster.gateway.daos.interfaces.property.GetAllPropertiesDocumentInDataBase;
import br.com.elasticsearchcluster.gateway.repositories.PropertyDocumentRepository;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAllPropertiesDocumentInDataBaseImp implements GetAllPropertiesDocumentInDataBase {

    private final PropertyDocumentRepository repository;

    @Override
    public Page<PropertyModel> execute(final Pageable pageable) {
        return repository.findAll(pageable).map(PropertyDocumentAdapter::toModel);
    }
}
