package br.com.elasticsearchcluster.usecases.address;

import br.com.elasticsearchcluster.gateway.daos.interfaces.address.SaveAddressDocumentInDataBase;
import br.com.elasticsearchcluster.models.AddressModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAddress {
    private final SaveAddressDocumentInDataBase saveAddressDocumentInDataBase;

    public AddressModel execute(AddressModel address) {
        return this.saveAddressDocumentInDataBase.execute(address);
    }
}
