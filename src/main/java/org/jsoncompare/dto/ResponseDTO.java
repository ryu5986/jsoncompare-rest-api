package org.jsoncompare.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    private String message;
    private String code;
    private T result;

    public ResponseDTO(String message){
        this.message = message;
    }

    public ResponseDTO(String code, String message){
        this.code = code;
    }

    public ResponseDTO(String message, T result){
        this.message = message;
        this.result = result;
    }
}
