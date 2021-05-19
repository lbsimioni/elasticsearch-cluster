package br.com.elasticsearchcluster.controllers;

import br.com.elasticsearchcluster.controllers.adapters.PropertyDTOAdapter;
import br.com.elasticsearchcluster.controllers.dtos.requests.PropertyDTORequest;
import br.com.elasticsearchcluster.controllers.dtos.responses.PropertyDTOResponse;
import br.com.elasticsearchcluster.exceptions.ResourceNotFoundException;
import br.com.elasticsearchcluster.usecases.property.CreateProperty;
import br.com.elasticsearchcluster.usecases.property.DeleteProperty;
import br.com.elasticsearchcluster.usecases.property.GetAllProperties;
import br.com.elasticsearchcluster.usecases.property.GetPropertyById;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
@Api(value = "Properties", tags = {"Properties"})
public class PropertyController {

    private final GetAllProperties getAllProperties;
    private final GetPropertyById getPropertyById;
    private final CreateProperty createProperty;
    private final DeleteProperty deleteProperty;

    @GetMapping
    @ApiOperation(value = "Get All Properties", notes = "Get All Properties")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all properties"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<PropertyDTOResponse>> findAll(@PageableDefault Pageable pageable) {
        try {
            var properties = getAllProperties.execute(pageable).map(PropertyDTOAdapter::toDTO);
            return ResponseEntity.ok(properties);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a Property By Id", notes = "Get a Property By Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return a property with the id informed"),
            @ApiResponse(code = 404, message = "Property not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
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
    @ApiOperation(value = "Save a Property", notes = "Save a Property")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Property saved with success"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PropertyDTOResponse> create(
            @RequestBody @Valid PropertyDTORequest request,
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

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Property", notes = "Delete a Property")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Property deleted with success"),
            @ApiResponse(code = 404, message = "Property not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable String id) {
        try {
            deleteProperty.execute(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
