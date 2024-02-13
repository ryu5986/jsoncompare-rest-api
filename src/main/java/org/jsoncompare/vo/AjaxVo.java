package org.jsoncompare.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjaxVo<T> {

    private String code;
    private String msg;
    private T data;

    public AjaxVo(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public AjaxVo(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
