package org.jsoncompare.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjaxVo<T> {

    private String message;
    private T result;

    public AjaxVo(String message){
        this.message = message;
    }

    public AjaxVo(String message, T result){
        this.message = message;
        this.result = result;
    }
}
