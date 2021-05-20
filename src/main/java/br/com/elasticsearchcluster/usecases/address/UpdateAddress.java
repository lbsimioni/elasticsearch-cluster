package br.com.elasticsearchcluster.usecases.address;

import br.com.elasticsearchcluster.gateway.daos.interfaces.address.SaveAddressDocumentInDataBase;
import br.com.elasticsearchcluster.models.AddressModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UpdateAddress {

    private final SaveAddressDocumentInDataBase saveAddressDocumentInDataBase;

    public AddressModel execute(final AddressModel address, final String id) {
        log.info("UseCase Updating address");
        address.setId(id);
        var model = saveAddressDocumentInDataBase.execute(address);
        log.info("UseCase Updated address");
        return model;
    }
}
