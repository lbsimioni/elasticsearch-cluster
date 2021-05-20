package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.SavePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import br.com.elasticsearchcluster.usecases.address.UpdateAddress;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UpdateProperty {

    private final UpdateAddress updateAddress;
    private final GetPropertyById getPropertyById;
    private final SavePropertyDocumentInDataBase savePropertyDocumentInDataBase;

    public final PropertyModel execute(final PropertyModel property, final String id) {
        log.info("UseCase Updating property");
        PropertyModel propertyInDataBase = getPropertyById.execute(id);
        property.setId(id);
        property.setAddress(updateAddress.execute(property.getAddress(), propertyInDataBase.getAddress().getId()));
        var model = savePropertyDocumentInDataBase.execute(property);
        log.info("UseCase Updated property");

        return model;
    }
}
