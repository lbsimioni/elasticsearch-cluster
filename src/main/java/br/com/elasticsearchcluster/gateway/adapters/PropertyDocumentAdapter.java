package br.com.elasticsearchcluster.gateway.adapters;

import br.com.elasticsearchcluster.gateway.documents.PropertyDocument;
import br.com.elasticsearchcluster.models.PropertyModel;

import java.util.Optional;

public class PropertyDocumentAdapter {
    public static PropertyModel toModel(PropertyDocument document) {
        var model = new PropertyModel();

        model.setId(document.getId());
        model.setAddress(AddressDocumentAdapter.toModel(document.getAddress()));
        model.setType(PropertyTypeDocumentAdapter.toModel(document.getType()));
        model.setCost(document.getCost());

        return model;
    }

    public static Optional<PropertyModel> toModel(Optional<PropertyDocument> documentOptional) {
        return documentOptional.map(PropertyDocumentAdapter::toModel);
    }

    public static PropertyDocument toDocument(PropertyModel model) {
        var document = new PropertyDocument();

        document.setId(model.getId());
        document.setAddress(AddressDocumentAdapter.toDocument(model.getAddress()));
        document.setType(PropertyTypeDocumentAdapter.toDocument(model.getType()));
        document.setCost(model.getCost());

        return document;
    }
}
