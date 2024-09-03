package com.app.repository;

import com.app.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing `Services` entities.
 * Provides CRUD operations and additional query methods for `Services` entities.
 */
@Repository // Marks this interface as a Spring Data repository for component scanning and automatic bean creation
public interface ServiceRepository extends JpaRepository<Services, Long> {
    // JpaRepository provides built-in methods such as save(), findById(), findAll(), deleteById(), etc.
    // You can define additional query methods here if needed
}
