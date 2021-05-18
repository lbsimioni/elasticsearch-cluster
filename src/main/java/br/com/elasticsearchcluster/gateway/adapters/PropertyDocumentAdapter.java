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
        if(documentOptional.isPresent())
            return Optional.of(toModel(documentOptional.get()));

        return Optional.empty();
    }

    public static PropertyDocument toDocument(PropertyModel model) {
        var document = new PropertyDocument();

        document.setId(document.getId());
        document.setAddress(AddressDocumentAdapter.toDocument(model.getAddress()));
        document.setType(PropertyTypeDocumentAdapter.toDocument(model.getType()));
        document.setCost(document.getCost());

        return document;
    }
}