package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing the Service entity.
 * Used for transferring service-related data between the client and server.
 */
@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-argument constructor
@Schema(description = "ServiceDto model information") // Provides schema metadata for Swagger/OpenAPI documentation
public class ServiceDto {

    /**
     * Unique identifier for the service.
     * 
     * @example 1
     */
    @Schema(description = "Unique identifier of the service", example = "1")
    private Long id;

    /**
     * Name of the service.
     * 
     * @example Haircut
     */
    @Schema(description = "Name of the service", example = "Haircut")
    private String name;

    /**
     * Detailed description of the service.
     * 
     * @example A professional haircut service
     */
    @Schema(description = "Detailed description of the service", example = "A professional haircut service")
    private String detail;

    /**
     * Price of the service.
     * 
     * @example 100.00
     */
    @Schema(description = "Price of the service", example = "100.00")
    private Double price;

    /**
     * Type or category of the service.
     * 
     * @example Grooming
     */
    @Schema(description = "Type or category of the service", example = "Grooming")
    private String type;
}
