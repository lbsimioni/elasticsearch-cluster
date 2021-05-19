package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.GetAllPropertiesDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetAllProperties {
    private final GetAllPropertiesDocumentInDataBase getAllPropertiesDocumentInDataBase;

    public Page<PropertyModel> execute(Pageable pageable) {
        return getAllPropertiesDocumentInDataBase.execute(pageable);
    }
}
