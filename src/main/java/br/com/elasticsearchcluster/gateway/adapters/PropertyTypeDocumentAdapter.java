package br.com.elasticsearchcluster.gateway.adapters;

import br.com.elasticsearchcluster.gateway.enums.PropertyTypeDocument;
import br.com.elasticsearchcluster.models.enums.PropertyTypeModel;

public class PropertyTypeDocumentAdapter {

    private PropertyTypeDocumentAdapter() {}

    public static PropertyTypeModel toModel(final PropertyTypeDocument document) {
        return PropertyTypeModel.valueOf(document.name());
    }

    public static PropertyTypeDocument toDocument(final PropertyTypeModel model) {
        return PropertyTypeDocument.valueOf(model.name());
    }
}
