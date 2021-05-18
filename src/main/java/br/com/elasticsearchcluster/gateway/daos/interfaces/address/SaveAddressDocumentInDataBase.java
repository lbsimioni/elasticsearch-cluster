package br.com.elasticsearchcluster.gateway.daos.interfaces.address;

import br.com.elasticsearchcluster.models.AddressModel;

public interface SaveAddressDocumentInDataBase {
    AddressModel execute(AddressModel address);
}
