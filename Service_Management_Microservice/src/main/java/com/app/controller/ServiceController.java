package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ServiceDto;
import com.app.service.ServiceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controller class for managing Service resources.
 * Provides CRUD operations for Service resources.
 */
@Tag(name = "Service Resource", description = "CRUD REST APIs for Service Resource")
@RestController
@RequestMapping("/api/services") // Base URL for all service-related endpoints
@Validated
public class ServiceController {

    @Autowired
    private ServiceService serviceService; // Service layer for handling business logic

    /**
     * Creates a new Service resource.
     * 
     * @param serviceDto DTO containing service details to be created
     * @return ResponseEntity with the created ServiceDto and HTTP status 201 Created
     */
    @Operation(summary = "Create Service", description = "Create Service API")
    @ApiResponse(responseCode = "201", description = "Service created")
    @PostMapping
    public ResponseEntity<ServiceDto> createService(@Valid @RequestBody ServiceDto serviceDto) {
        // Call service method to create a new service and return the created service
        ServiceDto createdService = serviceService.createService(serviceDto);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    /**
     * Retrieves all Service resources.
     * 
     * @return ResponseEntity with a list of all ServiceDto and HTTP status 200 OK
     */
    @Operation(summary = "Get All Services", description = "Get All Services API")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        // Call service method to get all services and return the list
        List<ServiceDto> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    /**
     * Retrieves a specific Service resource by ID.
     * 
     * @param id ID of the service to retrieve
     * @return ResponseEntity with the requested ServiceDto and HTTP status 200 OK
     */
    @Operation(summary = "Get Service by ID", description = "Get Service by ID API")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved service")
    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable Long id) {
        // Call service method to get the service by ID and return the service details
        ServiceDto serviceDto = serviceService.getServiceById(id);
        return ResponseEntity.ok(serviceDto);
    }

    /**
     * Updates an existing Service resource.
     * 
     * @param id ID of the service to update
     * @param serviceDto DTO containing updated service details
     * @return ResponseEntity with the updated ServiceDto and HTTP status 200 OK
     */
    @Operation(summary = "Update Service", description = "Update Service API")
    @ApiResponse(responseCode = "200", description = "Service updated")
    @PutMapping("/{id}")
    public ResponseEntity<ServiceDto> updateService(@PathVariable Long id, @Valid @RequestBody ServiceDto serviceDto) {
        // Call service method to update the service and return the updated service
        ServiceDto updatedService = serviceService.updateService(id, serviceDto);
        return ResponseEntity.ok(updatedService);
    }

    /**
     * Deletes a Service resource by ID.
     * 
     * @param id ID of the service to delete
     * @return ResponseEntity with HTTP status 204 No Content indicating successful deletion
     */
    @Operation(summary = "Delete Service", description = "Delete Service API")
    @ApiResponse(responseCode = "204", description = "Service deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        // Call service method to delete the service by ID
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build(); // No content in response body after successful deletion
    }
}
