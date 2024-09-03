package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Booking;

/**
 * Repository interface for managing `Booking` entities.
 * Provides CRUD operations and query methods for `Booking` entities.
 */
@Repository // Indicates that this interface is a Spring Data repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    // JpaRepository provides built-in methods such as save(), findById(), findAll(), deleteById(), etc.
    // Additional query methods can be defined here if needed
}
