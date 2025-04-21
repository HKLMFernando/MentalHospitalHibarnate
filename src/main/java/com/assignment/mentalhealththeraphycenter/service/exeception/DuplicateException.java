package com.assignment.mentalhealththeraphycenter.service.exeception;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);
    }
}
