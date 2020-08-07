package br.com.andre.whichepisodetowatchagain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

data class ExceptionEvent(val error: String)

@RestControllerAdvice
class ExceptionHandler() {

    @ExceptionHandler(TvShowNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun tvShowNotFound(exception: TvShowNotFoundException) = ExceptionEvent(exception.value)

}