package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.SavePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import br.com.elasticsearchcluster.usecases.address.UpdateAddress;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProperty {

    private final UpdateAddress updateAddress;
    private final GetPropertyById getPropertyById;
    private final SavePropertyDocumentInDataBase savePropertyDocumentInDataBase;

    public final PropertyModel execute(PropertyModel property, String id) {
        PropertyModel propertyInDataBase = getPropertyById.execute(id);
        property.setId(id);
        property.setAddress(updateAddress.execute(property.getAddress(), propertyInDataBase.getAddress().getId()));

        return savePropertyDocumentInDataBase.execute(property);
    }
}
