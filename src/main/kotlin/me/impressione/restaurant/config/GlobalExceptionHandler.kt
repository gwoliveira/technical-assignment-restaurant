package me.impressione.restaurant.config

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleTypeMismatchException(e: MethodArgumentNotValidException) =
        ResponseEntity.badRequest()
            .body(e.fieldError?.defaultMessage)
}