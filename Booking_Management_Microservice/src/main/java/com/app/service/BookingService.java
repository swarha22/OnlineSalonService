package com.app.service;

import java.util.List;

import com.app.dto.BookingDto;

/**
 * Service interface for managing Booking resources.
 * Defines the business logic methods for creating, retrieving, updating, and deleting bookings.
 */
public interface BookingService {

    /**
     * Creates a new Booking.
     * 
     * @param bookingDto DTO containing the booking details to be created
     * @return The created BookingDto with generated ID and other details
     */
    BookingDto createBooking(BookingDto bookingDto);

    /**
     * Retrieves a Booking by its ID.
     * 
     * @param id The ID of the booking to retrieve
     * @return The BookingDto corresponding to the provided ID
     */
    BookingDto getBookingById(Long id);

    /**
     * Updates an existing Booking.
     * 
     * @param id The ID of the booking to update
     * @param bookingDto DTO containing updated booking details
     * @return The updated BookingDto with the latest changes
     */
    BookingDto updateBooking(Long id, BookingDto bookingDto);

    /**
     * Deletes a Booking by its ID.
     * 
     * @param id The ID of the booking to delete
     */
    void deleteBooking(Long id);

    /**
     * Retrieves all Bookings.
     * 
     * @return A list of all BookingDto objects
     */
    List<BookingDto> getAllBookings();
}
