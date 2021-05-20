package io.flats.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type User not found exeption.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExeption extends ApiServerException{
}
