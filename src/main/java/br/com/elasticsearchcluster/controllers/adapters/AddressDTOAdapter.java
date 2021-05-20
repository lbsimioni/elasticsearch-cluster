package br.com.elasticsearchcluster.controllers.adapters;

import br.com.elasticsearchcluster.controllers.dtos.requests.AddressRequestDTO;
import br.com.elasticsearchcluster.controllers.dtos.responses.AddressResponseDTO;
import br.com.elasticsearchcluster.models.AddressModel;

public class AddressDTOAdapter {
    public static AddressResponseDTO toDTO(AddressModel model) {
        var dto = new AddressResponseDTO();

        dto.setId(model.getId());
        dto.setCep(model.getCep());
        dto.setNumber(model.getNumber());

        return dto;
    }

    public static AddressModel toModel(AddressRequestDTO request) {
        var model = new AddressModel();

        model.setCep(request.getCep());
        model.setNumber(request.getNumber());

        return model;
    }
}
