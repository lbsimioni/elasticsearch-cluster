package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.GetAllPropertiesDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GetAllProperties {
    private final GetAllPropertiesDocumentInDataBase getAllPropertiesDocumentInDataBase;

    public Page<PropertyModel> execute(final Pageable pageable) {
        log.info("UseCase Listing all properties");
        var models = getAllPropertiesDocumentInDataBase.execute(pageable);
        log.info("UseCase Listed all properties");
        return models;
    }
}
