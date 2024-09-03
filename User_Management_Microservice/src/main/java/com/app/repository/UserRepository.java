package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Users;

/**
 * Repository interface for managing {@link Users} entities.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations and query methods 
 * for the {@link Users} entity. It will automatically be implemented by Spring Data JPA.
 * </p>
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // No additional methods are defined here; JpaRepository provides standard CRUD operations.
    // Custom query methods can be added here if needed.
}
