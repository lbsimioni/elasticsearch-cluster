package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.exceptions.ResourceNotFoundException;
import br.com.elasticsearchcluster.gateway.daos.interfaces.property.GetPropertyByIdInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GetPropertyById {
    private final GetPropertyByIdInDataBase getPropertyByIdInDataBase;

    public PropertyModel execute(final String id) {
        log.info("UseCase getting property");
        var model = getPropertyByIdInDataBase.execute(id).orElseThrow(() -> {
            log.warn("UseCase Property not found");
            throw new ResourceNotFoundException("Property not found");
        });
        return model;
    }
}
