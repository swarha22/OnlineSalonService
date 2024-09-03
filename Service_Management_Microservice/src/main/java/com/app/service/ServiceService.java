package com.app.service;

import java.util.List;

import com.app.dto.ServiceDto;

/**
 * Service interface for managing `Service` resources.
 * Defines the business logic methods for creating, updating, retrieving, and deleting services.
 */
public interface ServiceService {

    /**
     * Creates a new service.
     * 
     * @param serviceDto DTO containing the details of the service to be created
     * @return The created ServiceDto with its generated ID and other details
     */
    ServiceDto createService(ServiceDto serviceDto);

    /**
     * Updates an existing service.
     * 
     * @param serviceId The ID of the service to be updated
     * @param serviceDto DTO containing updated details of the service
     * @return The updated ServiceDto with the latest changes
     */
    ServiceDto updateService(Long serviceId, ServiceDto serviceDto);

    /**
     * Deletes a service by its ID.
     * 
     * @param serviceId The ID of the service to be deleted
     */
    void deleteService(Long serviceId);

    /**
     * Retrieves a service by its ID.
     * 
     * @param serviceId The ID of the service to retrieve
     * @return The ServiceDto corresponding to the provided ID
     */
    ServiceDto getServiceById(Long serviceId);

    /**
     * Retrieves all services.
     * 
     * @return A list of all ServiceDto objects
     */
    List<ServiceDto> getAllServices();
}
