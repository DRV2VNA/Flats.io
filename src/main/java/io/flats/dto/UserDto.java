package io.flats.dto;

import java.util.Date;

import io.flats.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type User dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String role;
    private float rating;
    private Date dateUserFrom;

    private int realtorsCommentsNomber;

    /**
     * Instantiates a new User dto.
     *
     * @param firstName   the first name
     * @param secondName  the second name
     * @param lastName    the last name
     * @param username    the username
     * @param email       the email
     * @param phoneNumber the phone number
     * @param role        the role
     */
    public UserDto(String firstName, String secondName, String lastName, String username, String email, String phoneNumber, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole().getName();
    }
}
