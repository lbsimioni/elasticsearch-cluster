package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.SavePropertyDocumentInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProperty {

    private final SavePropertyDocumentInDataBase savePropertyDocumentInDataBase;

    public PropertyModel execute(PropertyModel property) {
        return savePropertyDocumentInDataBase.execute(property);
    }
}
