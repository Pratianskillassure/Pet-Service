package com.BT.Petzey.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.BT.Petzey.exception.NoInputException;
import com.BT.Petzey.exception.PetAlreadyDeactivated;
import com.BT.Petzey.exception.PetAlreadyExist;
import com.BT.Petzey.exception.PetNotFoundException;

public class ExceptionHandlerArguments {
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerArguments.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<?> handleInvalidArguments(MethodArgumentNotValidException e){

        //HashMap<String,String>errorMap=new HashMap<>();
        List<String>errorList=new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(error ->{
            log.error(error.getDefaultMessage());
            errorList.add(error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoInputException.class)
    public ResponseEntity<?> businessException2(NoInputException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PetAlreadyDeactivated.class)
    public ResponseEntity<?> businessException1(PetAlreadyDeactivated e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PetAlreadyExist.class)
    public ResponseEntity<?> businessException1(PetAlreadyExist e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<?> businessException1(PetNotFoundException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

    }
    

}
