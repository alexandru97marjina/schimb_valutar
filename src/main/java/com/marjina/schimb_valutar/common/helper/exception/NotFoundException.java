package com.marjina.schimb_valutar.common.helper.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends Exception {

    private String message;

    /**
     * Init constructor
     */
    public NotFoundException() {
        super();
    }

    /**
     * Init new exception with specific message and field
     *
     * @param msgTemplate thrown message
     */
    public NotFoundException(String msgTemplate) {
        this.message = msgTemplate;
    }

}