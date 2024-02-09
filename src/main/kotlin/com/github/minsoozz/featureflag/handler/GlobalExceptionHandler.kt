package com.github.minsoozz.featureflag.handler

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException::class)
    fun exceptionHandle(): String {
        return "해당 서비스는 점검 중 입니다."
    }
}