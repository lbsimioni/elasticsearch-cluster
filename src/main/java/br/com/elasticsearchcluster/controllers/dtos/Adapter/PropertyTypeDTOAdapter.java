package br.com.elasticsearchcluster.controllers.dtos.Adapter;

import br.com.elasticsearchcluster.models.enums.PropertyTypeModel;

public class PropertyTypeDTOAdapter {
    public static String toDTO(PropertyTypeModel model) {
        return model.name();
    }

    public static PropertyTypeModel toModel(String type) {
        return PropertyTypeModel.valueOf(type.trim().toUpperCase());
    }
}
