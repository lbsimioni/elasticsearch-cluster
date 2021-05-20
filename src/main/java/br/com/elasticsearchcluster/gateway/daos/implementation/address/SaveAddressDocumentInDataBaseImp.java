package br.com.elasticsearchcluster.gateway.daos.implementation.address;

import br.com.elasticsearchcluster.gateway.adapters.AddressDocumentAdapter;
import br.com.elasticsearchcluster.gateway.daos.interfaces.address.SaveAddressDocumentInDataBase;
import br.com.elasticsearchcluster.gateway.repositories.AddressDocumentRepository;
import br.com.elasticsearchcluster.models.AddressModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveAddressDocumentInDataBaseImp implements SaveAddressDocumentInDataBase {

    private final AddressDocumentRepository repository;

    @Override
    public AddressModel execute(final AddressModel address) {
        return AddressDocumentAdapter.toModel(repository.save(AddressDocumentAdapter.toDocument(address)));
    }
}
