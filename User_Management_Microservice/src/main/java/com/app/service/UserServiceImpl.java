package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Importing DTO and Entity classes
//import com.app.dto.BookingDto;
import com.app.dto.UserDto;
import com.app.entity.Users;
import com.app.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Create a new user with the provided details.
     * @param userDto A {@link UserDto} object containing the details of the user to be created.
     * @return A {@link UserDto} object representing the created user.
     * @throws IllegalArgumentException if the mobile number is null.
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = modelMapper.map(userDto, Users.class);

        // Ensure mobileNo is provided
        if (user.getMobileNo() == null) {
            throw new IllegalArgumentException("Mobile number must not be null");
        }

        Users savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    /**
     * Retrieve a user by their unique ID.
     * @param id The unique identifier of the user.
     * @return A {@link UserDto} object representing the user with the specified ID.
     * @throws EntityNotFoundException if no user is found with the given ID.
     */
    @Override
    public UserDto getUserById(Long id) {
        Optional<Users> user = userRepository.findById(id);
        return user.map(u -> modelMapper.map(u, UserDto.class))
                   .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    /**
     * Retrieve a list of all users.
     * @return A list of {@link UserDto} objects representing all users.
     */
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                             .map(user -> modelMapper.map(user, UserDto.class))
                             .collect(Collectors.toList());
    }

    /**
     * Update the details of an existing user.
     * @param id The unique identifier of the user to be updated.
     * @param userDto A {@link UserDto} object containing the updated details of the user.
     * @return A {@link UserDto} object representing the updated user.
     * @throws EntityNotFoundException if no user is found with the given ID.
     */
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

        // Manually update fields
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setMobileNo(userDto.getMobileNo());
        existingUser.setSex(userDto.getSex());
        // Update other fields as necessary

        Users updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    /**
     * Delete a user by their unique ID.
     * @param id The unique identifier of the user to be deleted.
     * @throws EntityNotFoundException if no user is found with the given ID.
     */
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

  
    // /**
    //  * Retrieve the booking history for a user.
    //  * @param userId The unique identifier of the user whose booking history is to be retrieved.
    //  * @return A list of {@link BookingDto} objects representing the user's booking history.
    //  * @throws EntityNotFoundException if no user is found with the given ID.
    //  */
    // @Override
    // public List<BookingDto> getUserBookingHistory(Long userId) {
    //     Users user = userRepository.findById(userId)
    //             .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));
    //     
    //     return user.getBookingHistory().stream()
    //             .map(booking -> modelMapper.map(booking, BookingDto.class))
    //             .collect(Collectors.toList());
    // }
}
