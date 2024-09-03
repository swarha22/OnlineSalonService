package com.app.service;

import com.app.dto.StaffDto;

import java.util.List;

/**
 * Service interface for managing staff members.
 * Provides methods to perform CRUD operations and retrieve staff information.
 */
public interface StaffService {

    /**
     * Create a new staff member.
     * 
     * @param staffDto the data transfer object containing staff details
     * @return the created {@link StaffDto} with assigned ID
     */
    StaffDto createStaff(StaffDto staffDto);

    /**
     * Update the details of an existing staff member.
     * 
     * @param staffId the unique identifier of the staff member to be updated
     * @param staffDto the data transfer object containing updated staff details
     * @return the updated {@link StaffDto}
     */
    StaffDto updateStaff(Long staffId, StaffDto staffDto);

    /**
     * Delete a staff member by ID.
     * 
     * @param staffId the unique identifier of the staff member to be deleted
     */
    void deleteStaff(Long staffId);

    /**
     * Retrieve a staff member by their ID.
     * 
     * @param staffId the unique identifier of the staff member to be retrieved
     * @return the {@link StaffDto} representing the staff member
     */
    StaffDto getStaffById(Long staffId);

    /**
     * Retrieve a list of all staff members.
     * 
     * @return a list of {@link StaffDto} representing all staff members
     */
    List<StaffDto> getAllStaff();
}
