package br.com.elasticsearchcluster.controllers;

import br.com.elasticsearchcluster.controllers.dtos.Adapter.PropertyDTOAdapter;
import br.com.elasticsearchcluster.controllers.dtos.Request.PropertyDTORequest;
import br.com.elasticsearchcluster.controllers.dtos.Response.PropertyDTOResponse;
import br.com.elasticsearchcluster.usecases.property.CreateProperty;
import br.com.elasticsearchcluster.usecases.property.GetAllProperties;
import br.com.elasticsearchcluster.usecases.property.GetPropertyById;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
public class PropertyController {

    private final GetAllProperties getAllProperties;
    private final GetPropertyById getPropertyById;
    private final CreateProperty createProperty;

    @GetMapping
    public ResponseEntity<Page<PropertyDTOResponse>> findAll(@PageableDefault Pageable pageable) {
        try {
            var properties = getAllProperties.execute(pageable).map(PropertyDTOAdapter::toDTO);
            return ResponseEntity.ok(properties);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTOResponse> findById(@PathVariable String id) {
        try {
            var propertyOptional = getPropertyById.execute(id);
            return propertyOptional
                    .map(propertyModel -> ResponseEntity.ok(PropertyDTOAdapter.toDTO(propertyModel)))
                    .orElseGet(() -> ResponseEntity.notFound().build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<PropertyDTOResponse> create(
            @RequestBody PropertyDTORequest request,
            UriComponentsBuilder uriBuilder) {
        try {
            var model = PropertyDTOAdapter.toModel(request);
            var response = PropertyDTOAdapter.toDTO(createProperty.execute(model));
            var uri = uriBuilder.path("/properties/{id}").buildAndExpand(response.getId()).toUri();
            return ResponseEntity.created(uri).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
