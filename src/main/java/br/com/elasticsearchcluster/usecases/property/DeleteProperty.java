package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.DeletePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import br.com.elasticsearchcluster.usecases.address.DeleteAddress;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteProperty {

    private final GetPropertyById getPropertyById;
    private final DeleteAddress deleteAddress;
    private final DeletePropertyDocumentInDataBase deletePropertyDocumentInDataBase;

    public void execute(final String id) {
        log.info("UseCase Deleting property");
        PropertyModel p = getPropertyById.execute(id);
        deleteAddress.execute(p.getAddress().getId());
        deletePropertyDocumentInDataBase.execute(id);
        log.info("UseCase Deleted property");
    }
}
