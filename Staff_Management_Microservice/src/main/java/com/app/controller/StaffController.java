package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StaffDto;
import com.app.service.StaffService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST controller for managing staff members.
 * Provides endpoints for CRUD operations on staff entities.
 */
@RestController
@RequestMapping("/api/staff")
@Tag(name = "Staff Management", description = "APIs for managing staff members")
public class StaffController {

    @Autowired
    private StaffService staffService; // Service for handling business logic related to staff

    /**
     * Endpoint to create a new staff member.
     * 
     * @param staffDto DTO containing the details of the new staff member
     * @return ResponseEntity containing the created StaffDto and HTTP status 201 (Created)
     */
    @Operation(summary = "Create a new staff member", description = "Create a new staff member in the system")
    @ApiResponse(responseCode = "201", description = "Staff created")
    @PostMapping
    public ResponseEntity<StaffDto> createStaff(@RequestBody StaffDto staffDto) {
        StaffDto createdStaff = staffService.createStaff(staffDto);
        return new ResponseEntity<>(createdStaff, HttpStatus.CREATED);
    }

    /**
     * Endpoint to retrieve a staff member by their ID.
     * 
     * @param id The ID of the staff member to retrieve
     * @return ResponseEntity containing the StaffDto and HTTP status 200 (OK)
     */
    @Operation(summary = "Get a staff member by ID", description = "Retrieve details of a staff member by their ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved staff")
    @GetMapping("/{id}")
    public ResponseEntity<StaffDto> getStaffById(@PathVariable("id") Long id) {
        StaffDto staffDto = staffService.getStaffById(id);
        return new ResponseEntity<>(staffDto, HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve all staff members.
     * 
     * @return ResponseEntity containing a list of StaffDto and HTTP status 200 (OK)
     */
    @Operation(summary = "Get all staff members", description = "Retrieve a list of all staff members")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaff() {
        List<StaffDto> staffList = staffService.getAllStaff();
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }

    /**
     * Endpoint to update an existing staff member.
     * 
     * @param id The ID of the staff member to update
     * @param staffDto DTO containing updated details of the staff member
     * @return ResponseEntity containing the updated StaffDto and HTTP status 200 (OK)
     */
    @Operation(summary = "Update a staff member", description = "Update details of an existing staff member")
    @ApiResponse(responseCode = "200", description = "Staff updated")
    @PutMapping("/{id}")
    public ResponseEntity<StaffDto> updateStaff(
            @PathVariable("id") Long id, 
            @RequestBody StaffDto staffDto) {
        StaffDto updatedStaff = staffService.updateStaff(id, staffDto);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }

    /**
     * Endpoint to delete a staff member by their ID.
     * 
     * @param id The ID of the staff member to delete
     * @return ResponseEntity with HTTP status 204 (No Content) indicating successful deletion
     */
    @Operation(summary = "Delete a staff member", description = "Remove a staff member from the system")
    @ApiResponse(responseCode = "204", description = "Staff deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("id") Long id) {
        staffService.deleteStaff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
