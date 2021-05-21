package br.com.elasticsearchcluster.controllers.adapters;

import br.com.elasticsearchcluster.controllers.dtos.requests.PropertyRequestDTO;
import br.com.elasticsearchcluster.controllers.dtos.responses.PropertyResponseDTO;
import br.com.elasticsearchcluster.models.PropertyModel;

import java.math.BigDecimal;

public class PropertyDTOAdapter {

    private PropertyDTOAdapter() {}

    public static PropertyResponseDTO toDTO(final PropertyModel model) {
        var dto = new PropertyResponseDTO();

        dto.setId(model.getId());
        dto.setAddress(AddressDTOAdapter.toDTO(model.getAddress()));
        dto.setType(PropertyTypeDTOAdapter.toDTO(model.getType()));
        dto.setCost(model.getCost());

        return dto;
    }

    public static PropertyModel toModel(final PropertyRequestDTO request) {
        var model = new PropertyModel();

        model.setAddress(AddressDTOAdapter.toModel(request.getAddress()));
        model.setType(PropertyTypeDTOAdapter.toModel(request.getType()));
        model.setCost(BigDecimal.valueOf(request.getCost()));

        return model;
    }
}
