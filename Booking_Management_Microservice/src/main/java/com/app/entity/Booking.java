package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Booking.
 * Mapped to the "booking" table in the database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Marks this class as a JPA entity
public class Booking {

    /**
     * Unique identifier for the Booking.
     * This is the primary key and is auto-generated.
     */
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the primary key should be auto-generated
    private Long id;

    /**
     * Price of the Booking.
     * Cannot be null.
     */
    @Column(nullable = false) // Maps this field to a database column with a NOT NULL constraint
    private Double price;

    /**
     * Status of the Booking.
     * Uses an enumerated type for predefined status values.
     * Cannot be null.
     */
    @Enumerated(EnumType.STRING) // Specifies that the enum should be stored as a string in the database
    @Column(nullable = false) // Maps this field to a database column with a NOT NULL constraint
    private BookingStatus status;
    
    /**
     * Represents the unique identifier for the user.
     * <p>
     * This field is used to uniquely identify a user in the system. It is expected to be
     * a positive number and should be set when a user is created or initialized. 
     * The value should be consistent across different operations that reference the same user.
     * </p>
     */
    private Long userId;

    /**
     * Represents the unique identifier for the staff member.
     * <p>
     * This field is used to uniquely identify a staff member in the system. It is expected to be
     * a positive number and should be assigned when a staff member is added or initialized. 
     * This ID is used to associate actions or records with a specific staff member.
     * </p>
     */
    private Long staffId;

    /**
     * Represents the unique identifier for the service.
     * <p>
     * This field is used to uniquely identify a service in the system. It is expected to be
     * a positive number and should be assigned when a service is created or initialized. 
     * The value should remain consistent across operations that reference the same service.
     * </p>
     */
    private Long serviceId;

}
