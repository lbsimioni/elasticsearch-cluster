package br.com.elasticsearchcluster.controllers.adapters;

import br.com.elasticsearchcluster.models.enums.PropertyTypeModel;

public class PropertyTypeDTOAdapter {
    public static String toDTO(final PropertyTypeModel model) {
        return model.name();
    }

    public static PropertyTypeModel toModel(final String type) {
        return PropertyTypeModel.valueOf(type.trim().toUpperCase());
    }
}
