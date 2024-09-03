package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingDto;
import com.app.entity.Booking;
import com.app.repository.BookingRepo;

/**
 * Implementation of the BookingService interface.
 * Contains business logic for managing Booking resources.
 */
@Service // Indicates that this class is a service component in the Spring context
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepository; // Repository for data access operations on Booking entities

    @Autowired
    private ModelMapper modelMapper; // Utility to map between DTOs and entity objects

    /**
     * Creates a new Booking and saves it to the database.
     * 
     * @param bookingDto DTO containing the booking details to be created
     * @return The created BookingDto with generated ID and other details
     */
    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        // Map the DTO to the entity
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        // Save the entity to the database
        Booking savedBooking = bookingRepository.save(booking);
        // Map the saved entity back to DTO and return
        return modelMapper.map(savedBooking, BookingDto.class);
    }

    /**
     * Retrieves a Booking by its ID.
     * 
     * @param id The ID of the booking to retrieve
     * @return The BookingDto corresponding to the provided ID
     * @throws RuntimeException if the booking with the specified ID is not found
     */
    @Override
    public BookingDto getBookingById(Long id) {
        // Find the booking by ID or throw an exception if not found
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        // Map the found entity to DTO and return
        return modelMapper.map(booking, BookingDto.class);
    }

    /**
     * Updates an existing Booking with new details.
     * 
     * @param id The ID of the booking to update
     * @param bookingDto DTO containing updated booking details
     * @return The updated BookingDto with the latest changes
     * @throws RuntimeException if the booking with the specified ID is not found
     */
    @Override
    public BookingDto updateBooking(Long id, BookingDto bookingDto) {
        // Find the existing booking by ID or throw an exception if not found
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        // Update fields of the existing booking with new values from the DTO
        existingBooking.setPrice(bookingDto.getPrice());
        existingBooking.setStatus(bookingDto.getStatus());
        existingBooking.setUserId(bookingDto.getUserId());
        existingBooking.setStaffId(bookingDto.getStaffId());
        existingBooking.setServiceId(bookingDto.getServiceId());
        // Save the updated entity to the database
        Booking updatedBooking = bookingRepository.save(existingBooking);
        // Map the updated entity to DTO and return
        return modelMapper.map(updatedBooking, BookingDto.class);
    }

    /**
     * Deletes a Booking by its ID.
     * 
     * @param id The ID of the booking to delete
     * @throws RuntimeException if the booking with the specified ID is not found
     */
    @Override
    public void deleteBooking(Long id) {
        // Find the booking by ID or throw an exception if not found
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        // Delete the found booking from the database
        bookingRepository.delete(booking);
    }

    /**
     * Retrieves all Bookings from the database.
     * 
     * @return A list of all BookingDto objects
     */
    @Override
    public List<BookingDto> getAllBookings() {
        // Find all bookings from the database
        List<Booking> bookings = bookingRepository.findAll();
        // Map each Booking entity to BookingDto and collect into a list
        return bookings.stream()
                .map(booking -> modelMapper.map(booking, BookingDto.class))
                .collect(Collectors.toList());
    }
    
}
