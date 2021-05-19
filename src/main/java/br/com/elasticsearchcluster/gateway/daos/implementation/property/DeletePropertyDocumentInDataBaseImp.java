package br.com.elasticsearchcluster.gateway.daos.implementation.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.DeletePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.gateway.repositories.PropertyDocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePropertyDocumentInDataBaseImp implements DeletePropertyDocumentInDataBase {

    private final PropertyDocumentRepository repository;

    @Override
    public void execute(String id) {
        repository.deleteById(id);
    }
}
