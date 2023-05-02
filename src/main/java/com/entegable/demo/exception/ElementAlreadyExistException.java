package com.entegable.demo.exception;

import javax.swing.text.Element;

public class ElementAlreadyExistException extends Exception{
    public ElementAlreadyExistException(String msg){
        super(msg);
    }
}
