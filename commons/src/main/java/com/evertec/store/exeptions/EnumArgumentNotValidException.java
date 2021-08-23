package com.evertec.store.exeptions;

public class EnumArgumentNotValidException extends RuntimeException {
	
	private static final long serialVersionUID = 6713422650199831316L;
	
	public EnumArgumentNotValidException(String errorMessage) {
        super(errorMessage);
    }

}
