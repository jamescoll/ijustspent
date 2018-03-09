package com.budgetmaster.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class BaseController {


    public static ResponseEntity ok() {
        return response(200);
    }

    public static ResponseEntity created() { return response(201); }

    public static ResponseEntity accepted() { return response(202); }

    public static ResponseEntity notFound() { return response(404); }

    //TODO make this guy much more robust and add methods for handling other scenarios
    public static <T extends Object> ResponseEntity<T> ok(T payload) {
        return response(200, payload);
    }

    public static <T extends Object> ResponseEntity<T> created(T payload) {
        return response(201, payload);
    }

   /* public static <T extends Object> ResponseEntity<T> accepted(T payload) {
        return response(201, payload);
    }*/

    public static <T extends Object> ResponseEntity<T> response(Integer code, T payload) {
        return new ResponseEntity<T>(payload, HttpStatus.valueOf(code));
    }

    //todo investigate if this guy is the right way for this
    public static ResponseEntity response(Integer code) {
        return new ResponseEntity(HttpStatus.valueOf(code));
    }
}
