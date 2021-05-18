package br.com.elasticsearchcluster.gateway.daos.interfaces.property;

import br.com.elasticsearchcluster.models.PropertyModel;

public interface SavePropertyDocumentInDataBase {
    PropertyModel execute(PropertyModel property);
}
