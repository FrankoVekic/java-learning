/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author frank
 */
public class CatchException extends Exception {
 
    private String message;

    public CatchException(String message) {
        super();
        this.message = message;
    }

    
    
    public String getMessage() {
        return message;
    }

    
    
}
