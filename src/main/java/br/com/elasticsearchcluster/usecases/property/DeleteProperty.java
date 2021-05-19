package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.DeletePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import br.com.elasticsearchcluster.usecases.address.DeleteAddress;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProperty {

    private final GetPropertyById getPropertyById;
    private final DeleteAddress deleteAddress;
    private final DeletePropertyDocumentInDataBase deletePropertyDocumentInDataBase;

    public void execute(String id) {
        PropertyModel p = getPropertyById.execute(id);
        deleteAddress.execute(p.getAddress().getId());
        deletePropertyDocumentInDataBase.execute(id);
    }
}
