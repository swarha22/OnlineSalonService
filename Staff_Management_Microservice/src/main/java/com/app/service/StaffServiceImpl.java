package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StaffDto;
import com.app.entity.Staff;
import com.app.repository.StaffRepository;

import java.util.List;

import java.util.stream.Collectors;

/**
 * Implementation of the {@link StaffService} interface.
 * Provides business logic for managing staff members.
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Create a new staff member.
     * 
     * @param staffDto the data transfer object containing staff details
     * @return the created {@link StaffDto} with assigned ID
     */
    @Override
    public StaffDto createStaff(StaffDto staffDto) {
        // Convert StaffDto to Staff entity
        Staff staff = modelMapper.map(staffDto, Staff.class);
        // Save the entity to the database
        Staff savedStaff = staffRepository.save(staff);
        // Convert the saved Staff entity back to StaffDto and return it
        return modelMapper.map(savedStaff, StaffDto.class);
    }

    /**
     * Update an existing staff member.
     * 
     * @param staffId the unique identifier of the staff member to be updated
     * @param staffDto the data transfer object containing updated staff details
     * @return the updated {@link StaffDto}
     */
    @Override
    public StaffDto updateStaff(Long staffId, StaffDto staffDto) {
        // Retrieve the existing staff member
        Staff existingStaff = staffRepository.findById(staffId)
            .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + staffId));
        
        // Update the staff entity with new details
        existingStaff.setName(staffDto.getName());
        existingStaff.setDetails(staffDto.getDetails());
        existingStaff.setGender(staffDto.getGender());
        existingStaff.setServiceId(staffDto.getServiceId());
        // Save the updated entity to the database
        Staff updatedStaff = staffRepository.save(existingStaff);
        // Convert the updated Staff entity back to StaffDto and return it
        return modelMapper.map(updatedStaff, StaffDto.class);
    }

    /**
     * Delete a staff member by ID.
     * 
     * @param staffId the unique identifier of the staff member to be deleted
     */
    @Override
    public void deleteStaff(Long staffId) {
        // Delete the staff member by ID
        staffRepository.deleteById(staffId);
    }

    /**
     * Retrieve a staff member by their ID.
     * 
     * @param staffId the unique identifier of the staff member to be retrieved
     * @return the {@link StaffDto} representing the staff member
     */
    @Override
    public StaffDto getStaffById(Long staffId) {
        // Retrieve the staff member by ID
        Staff staff = staffRepository.findById(staffId)
            .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + staffId));
        // Convert the Staff entity to StaffDto and return it
        return modelMapper.map(staff, StaffDto.class);
    }

    /**
     * Retrieve a list of all staff members.
     * 
     * @return a list of {@link StaffDto} representing all staff members
     */
    @Override
    public List<StaffDto> getAllStaff() {
        // Retrieve all staff members from the database
        List<Staff> staffList = staffRepository.findAll();
        // Convert each Staff entity to StaffDto and collect them into a list
        return staffList.stream()
                        .map(staff -> modelMapper.map(staff, StaffDto.class))
                        .collect(Collectors.toList());
    }
}
