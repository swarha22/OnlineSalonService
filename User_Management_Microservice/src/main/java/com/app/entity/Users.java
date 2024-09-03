package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a user in the system.
 * This class maps to the 'users' table in the database and holds user-related information.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    /**
     * Unique identifier for the user.
     * This is the primary key of the 'users' table and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the user.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Email address of the user.
     * This field must be unique and cannot be null.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Mobile number of the user.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String mobileNo;

    /**
     * Password of the user.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Sex of the user.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String sex;

    /**
     * Role assigned to the user.
     * This field determines the access level or permissions of the user within the system.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    // Uncomment and modify the following section if the user has a relationship with booking history.
    // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    // private List<Booking> bookingHistory;
}
