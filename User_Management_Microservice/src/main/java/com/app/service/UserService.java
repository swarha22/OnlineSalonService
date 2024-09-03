package com.app.service;

import java.util.List;

import com.app.dto.UserDto;

/**
 * Service interface for managing user profiles.
 * <p>
 * This interface defines the contract for the user-related operations in the application.
 * It outlines methods for creating, retrieving, updating, and deleting users.
 * </p>
 */
public interface UserService {

    /**
     * Create a new user with the provided details.
     * @param userDto A {@link UserDto} object containing the details of the user to be created.
     * @return A {@link UserDto} object representing the created user.
     */
    UserDto createUser(UserDto userDto);

    /**
     * Retrieve a user by their unique ID.
     * @param id The unique identifier of the user.
     * @return A {@link UserDto} object representing the user with the specified ID.
     */
    UserDto getUserById(Long id);

    /**
     * Retrieve a list of all users.
     * @return A list of {@link UserDto} objects representing all users.
     */
    List<UserDto> getAllUsers();

    /**
     * Update the details of an existing user.
     * @param id The unique identifier of the user to be updated.
     * @param userDto A {@link UserDto} object containing the updated details of the user.
     * @return A {@link UserDto} object representing the updated user.
     */
    UserDto updateUser(Long id, UserDto userDto);

    /**
     * Delete a user by their unique ID.
     * @param id The unique identifier of the user to be deleted.
     */
    void deleteUser(Long id);

    // Uncomment if user booking history retrieval functionality is implemented
    // /**
    //  * Retrieve the booking history for a user.
    //  * @param userId The unique identifier of the user whose booking history is to be retrieved.
    //  * @return A list of {@link BookingDto} objects representing the user's booking history.
    //  */
    // List<BookingDto> getUserBookingHistory(Long userId);
}
