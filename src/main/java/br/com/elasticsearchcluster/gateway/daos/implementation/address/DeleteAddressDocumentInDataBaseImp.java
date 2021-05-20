package br.com.elasticsearchcluster.gateway.daos.implementation.address;

import br.com.elasticsearchcluster.gateway.daos.interfaces.address.DeleteAddressDocumentInDataBase;
import br.com.elasticsearchcluster.gateway.repositories.AddressDocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteAddressDocumentInDataBaseImp implements DeleteAddressDocumentInDataBase {

    private final AddressDocumentRepository repository;

    @Override
    public void execute(final String id) {
        repository.deleteById(id);
    }
}
