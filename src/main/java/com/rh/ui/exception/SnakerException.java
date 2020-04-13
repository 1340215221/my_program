package com.rh.ui.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SnakerException extends RuntimeException {

    public SnakerException(String message) {
        super(message);
    }

}
