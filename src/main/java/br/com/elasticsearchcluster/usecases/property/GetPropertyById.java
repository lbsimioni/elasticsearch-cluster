package br.com.elasticsearchcluster.usecases.property;

import br.com.elasticsearchcluster.gateway.daos.interfaces.property.GetPropertyByIdInDataBase;
import br.com.elasticsearchcluster.models.PropertyModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetPropertyById {
    private final GetPropertyByIdInDataBase getPropertyByIdInDataBase;

    public Optional<PropertyModel> execute(String id) {
        return getPropertyByIdInDataBase.execute(id);
    }
}
