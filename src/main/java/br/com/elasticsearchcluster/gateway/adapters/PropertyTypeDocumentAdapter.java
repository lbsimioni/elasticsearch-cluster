package br.com.elasticsearchcluster.gateway.adapters;

import br.com.elasticsearchcluster.gateway.enums.PropertyTypeDocument;
import br.com.elasticsearchcluster.models.enums.PropertyTypeModel;

public class PropertyTypeDocumentAdapter {
    public static PropertyTypeModel toModel(PropertyTypeDocument document) {
        return PropertyTypeModel.valueOf(document.name());
    }

    public static PropertyTypeDocument toDocument(PropertyTypeModel model) {
        return PropertyTypeDocument.valueOf(model.name());
    }
}
