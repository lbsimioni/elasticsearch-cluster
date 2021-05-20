package br.com.elasticsearchcluster.gateway.adapters;

import br.com.elasticsearchcluster.gateway.documents.AddressDocument;
import br.com.elasticsearchcluster.models.AddressModel;

import java.util.Optional;

public class AddressDocumentAdapter {
    public static AddressModel toModel(final AddressDocument document) {
        var model = new AddressModel();

        model.setId(document.getId());
        model.setCep(document.getCep());
        model.setNumber(document.getNumber());

        return model;
    }

    public static Optional<AddressModel> toModel(final Optional<AddressDocument> documentOptional) {
        return documentOptional.map(AddressDocumentAdapter::toModel);
    }

    public static AddressDocument toDocument(final AddressModel model) {
        var document = new AddressDocument();

        document.setId(model.getId());
        document.setCep(model.getCep());
        document.setNumber(model.getNumber());

        return document;
    }
}
