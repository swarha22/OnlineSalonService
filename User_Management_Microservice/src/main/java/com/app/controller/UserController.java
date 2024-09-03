package com.app.controller;

import com.app.dto.UserDto;
//import com.app.dto.BookingDto;
import com.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing user profiles and authentication.
 * Provides REST endpoints for creating, retrieving, updating, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "APIs for managing user profiles and authentication")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create a new user.
     * 
     * @param userDto the data transfer object containing user details
     * @return a ResponseEntity containing the created UserDto
     */
    @Operation(summary = "Create a new user", description = "Create a new user with the provided details")
    @ApiResponse(responseCode = "200", description = "User created successfully")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * Retrieve a user by their unique ID.
     * 
     * @param id the unique identifier of the user
     * @return a ResponseEntity containing the retrieved UserDto
     */
    @Operation(summary = "Get user by ID", description = "Retrieve a user by their unique ID")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Update the details of an existing user.
     * 
     * @param id the unique identifier of the user to be updated
     * @param userDto the data transfer object containing updated user details
     * @return a ResponseEntity containing the updated UserDto
     */
    @Operation(summary = "Update an existing user", description = "Update the details of an existing user")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete a user by their unique ID.
     * 
     * @param id the unique identifier of the user to be deleted
     * @return a ResponseEntity with HTTP status 204 (No Content) indicating successful deletion
     */
    @Operation(summary = "Delete a user by ID", description = "Delete a user by their unique ID")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retrieve a list of all users.
     * 
     * @return a ResponseEntity containing a list of UserDto
     */
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    @ApiResponse(responseCode = "200", description = "List of users retrieved successfully")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    
}
