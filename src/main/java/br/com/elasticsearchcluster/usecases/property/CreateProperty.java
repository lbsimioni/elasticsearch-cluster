package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.SavePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import br.com.elasticsearchcluster.usecases.address.CreateAddress;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProperty {

    private final CreateAddress createAddress;
    private final SavePropertyDocumentInDataBase savePropertyDocumentInDataBase;

    public PropertyModel execute(PropertyModel property) {
        property.setAddress(createAddress.execute(property.getAddress()));
        return savePropertyDocumentInDataBase.execute(property);
    }
}
