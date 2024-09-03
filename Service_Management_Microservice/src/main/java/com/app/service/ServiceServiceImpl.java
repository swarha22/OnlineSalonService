package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ServiceDto;
import com.app.entity.Services;
import com.app.repository.ServiceRepository;

/**
 * Implementation of the ServiceService interface.
 * Provides the business logic for managing `Services` entities.
 */
@Service // Marks this class as a Spring service component for dependency injection
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository; // Repository for CRUD operations on Services entities

    @Autowired
    private ModelMapper modelMapper; // Mapper for converting between ServiceDto and Services entities

    /**
     * Creates a new service.
     * 
     * @param serviceDto DTO containing the details of the service to be created
     * @return The created ServiceDto with its generated ID and other details
     */
    @Override
    public ServiceDto createService(ServiceDto serviceDto) {
        // Convert ServiceDto to Services entity
        Services services = modelMapper.map(serviceDto, Services.class);
        // Save the entity to the repository
        Services savedService = serviceRepository.save(services);
        // Convert the saved entity back to ServiceDto and return
        return modelMapper.map(savedService, ServiceDto.class);
    }

    /**
     * Updates an existing service.
     * 
     * @param serviceId The ID of the service to be updated
     * @param serviceDto DTO containing updated details of the service
     * @return The updated ServiceDto with the latest changes
     */
    @Override
    public ServiceDto updateService(Long serviceId, ServiceDto serviceDto) {
        // Retrieve the existing service from the repository
        Services existingService = serviceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with ID: " + serviceId));
        
        // Update fields of the existing service with new values
        existingService.setName(serviceDto.getName());
        existingService.setDetail(serviceDto.getDetail());
        existingService.setPrice(serviceDto.getPrice());
        existingService.setType(serviceDto.getType());

        // Save the updated entity to the repository
        Services updatedService = serviceRepository.save(existingService);
        // Convert the updated entity back to ServiceDto and return
        return modelMapper.map(updatedService, ServiceDto.class);
    }

    /**
     * Deletes a service by its ID.
     * 
     * @param serviceId The ID of the service to be deleted
     */
    @Override
    public void deleteService(Long serviceId) {
        // Retrieve the existing service from the repository
        Services existingService = serviceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with ID: " + serviceId));
        
        // Delete the entity from the repository
        serviceRepository.delete(existingService);
    }

    /**
     * Retrieves a service by its ID.
     * 
     * @param serviceId The ID of the service to retrieve
     * @return The ServiceDto corresponding to the provided ID
     */
    @Override
    public ServiceDto getServiceById(Long serviceId) {
        // Retrieve the service from the repository
        Services service = serviceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with ID: " + serviceId));
        
        // Convert the entity to ServiceDto and return
        return modelMapper.map(service, ServiceDto.class);
    }

    /**
     * Retrieves all services.
     * 
     * @return A list of all ServiceDto objects
     */
    @Override
    public List<ServiceDto> getAllServices() {
        // Retrieve all services from the repository
        List<Services> services = serviceRepository.findAll();
        // Convert the list of entities to a list of DTOs and return
        return services.stream()
            .map(service -> modelMapper.map(service, ServiceDto.class))
            .collect(Collectors.toList());
    }
}
