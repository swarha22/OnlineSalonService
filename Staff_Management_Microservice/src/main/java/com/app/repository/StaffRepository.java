package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Staff;

/**
 * Repository interface for managing {@link Staff} entities.
 * 
 * Extends JpaRepository to provide basic CRUD operations and query methods for Staff entities.
 * 
 * @see JpaRepository
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // Custom query methods (if needed) can be added here
    // Example: List<Staff> findByName(String name);
}
