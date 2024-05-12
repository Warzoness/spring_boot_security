package com.dayoungapplication.exception;

public enum ErrorCode {
    USER_EXISTED(1002, "User already existed"),
    UNCATEGORIZED_EXCEPTION(1001, "Uncategorized exception"),
    USERNAME_INVALID(1003, "Username must be between 5 and 20 characters"),
    PASSWORD_INVALID(1004, "Password must be between 5 and 20 characters"),
    INVALID_KEY(1005, "Invalid key"),
    USER_NOT_EXISTED(1006, "User not existed"),
    AUTHENTICATION_FAILED(1007, "Authentication failed"),
    ;

    private int errorCode;
    private String errorMessage;

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
