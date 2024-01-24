package com.codewitharjun.fullstackbackend.exception;

public class DaretNotFoundException extends RuntimeException{
	
    public DaretNotFoundException(Long id){
        super("Could not found the daret with id "+ id);
    }
}
