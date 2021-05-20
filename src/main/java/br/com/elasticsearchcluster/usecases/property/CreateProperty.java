package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.SavePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import br.com.elasticsearchcluster.usecases.address.CreateAddress;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateProperty {

    private final CreateAddress createAddress;
    private final SavePropertyDocumentInDataBase savePropertyDocumentInDataBase;

    public PropertyModel execute(final PropertyModel property) {
        log.info("UseCase Creating property");
        property.setAddress(createAddress.execute(property.getAddress()));
        var model = savePropertyDocumentInDataBase.execute(property);
        log.info("UseCase Created property");
        return model;
    }
}
