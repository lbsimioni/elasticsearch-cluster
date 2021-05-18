package br.com.elasticsearchcluster.gateway.daos.interfaces.property;

import br.com.elasticsearchcluster.models.PropertyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllPropertiesDocumentInDataBase {
    Page<PropertyModel> execute(Pageable pageable);
}
