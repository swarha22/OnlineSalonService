package com.app.dto;

import com.app.entity.Gender;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing a staff member.
 * Used to transfer staff information between the client and server.
 */
@Data
@Schema(description = "StaffDto model information")
public class StaffDto {

    /**
     * Unique identifier for the staff member.
     * Typically assigned by the database.
     * 
     * @example 1
     */
    @Schema(description = "Unique identifier for the staff member", example = "1")
    private Long id;

    /**
     * Name of the staff member.
     * Represents the full name of the staff member.
     * 
     * @example John Doe
     */
    @Schema(description = "Name of the staff member", example = "chandini jain")
    private String name;

    /**
     * Details about the staff member.
     * Provides additional information such as job title, experience, or other relevant details.
     * 
     * @example Senior stylist with 10 years of experience
     */
    @Schema(description = "Details about the staff member", example = "Senior stylist with 8 years of experience")
    private String details;

    /**
     * Gender of the staff member.
     * Represents the gender of the staff member. This field uses an enumeration to standardize gender values.
     * 
     * @example MALE
     */
    @Schema(description = "Gender of the staff member", example = "FEMALE")
    private Gender gender;
    /**
     * Represents the unique identifier for the service.
     * <p>
     * This field is used to uniquely identify a service in the system. It is expected to be 
     * a positive number and should be set during the service's creation or initialization. 
     * The value of this field should be consistent across different operations that reference 
     * the same service.
     * </p>
     */
    @Schema(description = "Id for the service", example = "1")
    private Long serviceId;

   

}
