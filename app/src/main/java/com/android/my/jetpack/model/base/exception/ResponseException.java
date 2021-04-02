package com.android.my.jetpack.model.base.exception;

public class ResponseException extends BaseException {
    public ResponseException(int code, String message) {
        super(code, message);
    }
}
