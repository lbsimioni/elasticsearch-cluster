package br.com.elasticsearchcluster.gateway.daos.implementation.property;

import br.com.elasticsearchcluster.gateway.adapters.PropertyDocumentAdapter;
import br.com.elasticsearchcluster.gateway.daos.interfaces.property.GetPropertyByIdInDataBase;
import br.com.elasticsearchcluster.gateway.repositories.PropertyDocumentRepository;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetPropertyByIdInDataBaseImp implements GetPropertyByIdInDataBase {

    private final PropertyDocumentRepository repository;

    @Override
    public Optional<PropertyModel> execute(final String id) {
        return PropertyDocumentAdapter.toModel(repository.findById(id));
    }
}
