package com.app.dto;

import java.util.List;

import com.app.entity.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user information.
 * This class is used to transfer user data between different layers of the application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto model information")
public class UserDto {

    /**
     * Unique identifier for the user.
     * 
     * @example 1
     */
    @Schema(description = "Unique identifier of the user", example = "1")
    private Long id;

    /**
     * Name of the user.
     * 
     * @example Sanjana Ravath
     */
    @Schema(description = "Name of the user", example = "Sanjana Ravath")
    private String name;

    /**
     * Email address of the user.
     * 
     * @example sanjanaravath23@gmail.com
     */
    @Schema(description = "Email address of the user", example = "sanjanaravath23@gmail.com")
    private String email;

    /**
     * Mobile number of the user.
     * 
     * @example +1234554321
     */
    @Schema(description = "Mobile number of the user", example = "+1234554321")
    private String mobileNo;

    /**
     * Password of the user.
     * 
     * @example 123456
     */
    @Schema(description = "Password of the user", example = "123456")
    private String password;

    /**
     * Sex of the user.
     * 
     * @example Female
     */
    @Schema(description = "Sex of the user", example = "Female")
    private String sex;

    /**
     * Role assigned to the user, which defines their access permissions.
     * 
     * @example ADMIN
     */
    @Schema(description = "Role assigned to the user", example = "ADMIN")
    private Role role;
}
