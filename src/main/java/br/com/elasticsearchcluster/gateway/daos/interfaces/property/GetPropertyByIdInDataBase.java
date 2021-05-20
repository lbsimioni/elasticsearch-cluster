package br.com.elasticsearchcluster.gateway.daos.interfaces.property;

import br.com.elasticsearchcluster.models.PropertyModel;

import java.util.Optional;

public interface GetPropertyByIdInDataBase {
    Optional<PropertyModel> execute(final String id);
}
