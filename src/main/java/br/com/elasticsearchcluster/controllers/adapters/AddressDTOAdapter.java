package br.com.elasticsearchcluster.controllers.adapters;

import br.com.elasticsearchcluster.controllers.dtos.requests.AddressDTORequest;
import br.com.elasticsearchcluster.controllers.dtos.responses.AddressDTOResponse;
import br.com.elasticsearchcluster.models.AddressModel;

public class AddressDTOAdapter {
    public static AddressDTOResponse toDTO(AddressModel model) {
        var dto = new AddressDTOResponse();

        dto.setId(model.getId());
        dto.setCep(model.getCep());
        dto.setNumber(model.getNumber());

        return dto;
    }

    public static AddressModel toModel(AddressDTORequest request) {
        var model = new AddressModel();

        model.setCep(request.getCep());
        model.setNumber(request.getNumber());

        return model;
    }
}
