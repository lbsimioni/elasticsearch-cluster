package br.com.elasticsearchcluster.gateway.adapters;

import br.com.elasticsearchcluster.gateway.documents.AddressDocument;
import br.com.elasticsearchcluster.models.AddressModel;

public class AddressDocumentAdapter {
    public static AddressModel toModel(AddressDocument document) {
        var model = new AddressModel();

        model.setId(document.getId());
        model.setCep(document.getCep());
        model.setNumber(document.getNumber());

        return model;
    }

    public static AddressDocument toDocument(AddressModel model) {
        var document = new AddressDocument();

        document.setId(model.getId());
        document.setCep(model.getCep());
        document.setNumber(model.getNumber());

        return document;
    }
}
