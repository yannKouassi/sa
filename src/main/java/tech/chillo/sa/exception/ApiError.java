package tech.chillo.sa.exception;

public record ApiError(
        int status,
        String error,
        String message
) {}
