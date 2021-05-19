package br.com.elasticsearchcluster.controllers.dtos.Adapter;

import br.com.elasticsearchcluster.controllers.dtos.Request.PropertyDTORequest;
import br.com.elasticsearchcluster.controllers.dtos.Response.PropertyDTOResponse;
import br.com.elasticsearchcluster.models.PropertyModel;

import java.math.BigDecimal;

public class PropertyDTOAdapter {
    public static PropertyDTOResponse toDTO(PropertyModel model) {
        var dto = new PropertyDTOResponse();

        dto.setId(model.getId());
        dto.setAddress(AddressDTOAdapter.toDTO(model.getAddress()));
        dto.setType(PropertyTypeDTOAdapter.toDTO(model.getType()));
        dto.setCost(model.getCost());

        return dto;
    }

    public static PropertyModel toModel(PropertyDTORequest request) {
        var model = new PropertyModel();

        model.setAddress(AddressDTOAdapter.toModel(request.getAddress()));
        model.setType(PropertyTypeDTOAdapter.toModel(request.getType()));
        model.setCost(BigDecimal.valueOf(request.getCost()));

        return model;
    }
}
