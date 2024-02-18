package org.jsoncompare.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVo<T> {

    private String message;
    private T result;

    public ResponseVo(String message){
        this.message = message;
    }

    public ResponseVo(String message, T result){
        this.message = message;
        this.result = result;
    }
}
