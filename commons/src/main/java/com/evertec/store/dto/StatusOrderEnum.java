package com.evertec.store.dto;

import com.evertec.store.exeptions.EnumArgumentNotValidException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusOrderEnum {
	CREATED("CREATED"), PAYED("PAYED"), REJECTED("REJECTED");

	private String value;
	
	StatusOrderEnum(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
	    return value;
	}
	
	@JsonCreator
	public static StatusOrderEnum fromText(String value) throws EnumArgumentNotValidException{
        for(StatusOrderEnum r : StatusOrderEnum.values()){
            if(r.toString().equals(value)){
                return r;
            }
        }
        throw new EnumArgumentNotValidException("the status order its not valid.");
    }
}
