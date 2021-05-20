package br.com.elasticsearchcluster.usecases.address;

import br.com.elasticsearchcluster.gateway.daos.interfaces.address.SaveAddressDocumentInDataBase;
import br.com.elasticsearchcluster.models.AddressModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateAddress {
    private final SaveAddressDocumentInDataBase saveAddressDocumentInDataBase;

    public AddressModel execute(final AddressModel address) {
        log.info("UseCase Creating address");
        AddressModel model = this.saveAddressDocumentInDataBase.execute(address);
        log.info("UseCase Created address");
        return model;
    }
}
