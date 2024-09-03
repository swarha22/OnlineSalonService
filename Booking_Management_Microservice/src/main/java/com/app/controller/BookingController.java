package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingDto;
import com.app.service.BookingService;

/**
 * Controller class for managing Booking resources.
 * Provides CRUD operations for Booking resources.
 */
@RestController
@RequestMapping("/api/bookings") // Base URL for all booking-related endpoints
public class BookingController {

    @Autowired
    private BookingService bookingService; // Service layer for handling business logic related to bookings

    /**
     * Creates a new Booking resource.
     * 
     * @param bookingDto DTO containing the booking details to be created
     * @return ResponseEntity with the created BookingDto and HTTP status 200 OK
     */
    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        // Call service method to create a new booking and return the created booking
        BookingDto createdBooking = bookingService.createBooking(bookingDto);
        return ResponseEntity.ok(createdBooking);
    }

    /**
     * Retrieves a specific Booking resource by its ID.
     * 
     * @param id ID of the booking to retrieve
     * @return ResponseEntity with the requested BookingDto and HTTP status 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
        // Call service method to get the booking by ID and return the booking details
        BookingDto bookingDto = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDto);
    }

    /**
     * Updates an existing Booking resource.
     * 
     * @param id ID of the booking to update
     * @param bookingDto DTO containing updated booking details
     * @return ResponseEntity with the updated BookingDto and HTTP status 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        // Call service method to update the booking and return the updated booking
        BookingDto updatedBooking = bookingService.updateBooking(id, bookingDto);
        return ResponseEntity.ok(updatedBooking);
    }

    /**
     * Deletes a Booking resource by its ID.
     * 
     * @param id ID of the booking to delete
     * @return ResponseEntity with HTTP status 204 No Content indicating successful deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        // Call service method to delete the booking by ID
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build(); // No content in response body after successful deletion
    }

    /**
     * Retrieves all Booking resources.
     * 
     * @return ResponseEntity with a list of all BookingDto and HTTP status 200 OK
     */
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        // Call service method to get all bookings and return the list
        List<BookingDto> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
