package br.com.elasticsearchcluster.controllers;

import br.com.elasticsearchcluster.controllers.adapters.PropertyDTOAdapter;
import br.com.elasticsearchcluster.controllers.dtos.requests.PropertyRequestDTO;
import br.com.elasticsearchcluster.controllers.dtos.responses.PropertyResponseDTO;
import br.com.elasticsearchcluster.usecases.property.CreateProperty;
import br.com.elasticsearchcluster.usecases.property.DeleteProperty;
import br.com.elasticsearchcluster.usecases.property.GetAllProperties;
import br.com.elasticsearchcluster.usecases.property.GetPropertyById;
import br.com.elasticsearchcluster.usecases.property.UpdateProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/properties")
@AllArgsConstructor
@Api(value = "Properties", tags = {"Properties"})
public class PropertyController {

    private final GetAllProperties getAllProperties;
    private final GetPropertyById getPropertyById;
    private final CreateProperty createProperty;
    private final DeleteProperty deleteProperty;
    private final UpdateProperty updateProperty;

    @GetMapping
    @ApiOperation(value = "Get All Properties", notes = "Get All Properties")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all properties"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<PropertyResponseDTO>> findAll(@PageableDefault final Pageable pageable) {
        log.info("Controller Listing all properties");
        var properties = getAllProperties.execute(pageable).map(PropertyDTOAdapter::toDTO);
        log.info("Controller Listed all properties");
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a Property By Id", notes = "Get a Property By Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return a property with the id informed"),
            @ApiResponse(code = 404, message = "Property not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PropertyResponseDTO> findById(@PathVariable final String id) {
        log.info("Controller Getting property with id " + id);
        var response = PropertyDTOAdapter.toDTO(getPropertyById.execute(id));
        log.info("Controller Getted property with id " + id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ApiOperation(value = "Save a Property", notes = "Save a Property")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Property saved with success"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity<PropertyResponseDTO> create(
            @RequestBody @Valid final PropertyRequestDTO request,
            final UriComponentsBuilder uriBuilder) {
        
        log.info("Controller Creating property");

        var model = PropertyDTOAdapter.toModel(request);
        var response = PropertyDTOAdapter.toDTO(createProperty.execute(model));
        var uri = uriBuilder.path("/properties/{id}").buildAndExpand(response.getId()).toUri();

        log.info("Controller Created property");
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Property", notes = "Delete a Property")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Property deleted with success"),
            @ApiResponse(code = 404, message = "Property not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        log.info("Controller Deleting property with id " + id);
        deleteProperty.execute(id);
        log.info("Controller Deleted property with id " + id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a Property", notes = "Update a Property")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Property updated with success"),
            @ApiResponse(code = 404, message = "Property not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ResponseEntity<PropertyResponseDTO> update(
            @PathVariable final String id,
            @RequestBody final PropertyRequestDTO request) {

        log.info("Controller Updating property with id " + id);
        var property = updateProperty.execute(PropertyDTOAdapter.toModel(request), id);
        log.info("Controller Updated property with id " + id);
        return ResponseEntity.ok(PropertyDTOAdapter.toDTO(property));
    }

}
