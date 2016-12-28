/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ct.uareportbuilder;

/**
 * Catches scenarios where user agent cannot be parsed.
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class UserAgentParseException extends RuntimeException {

    public UserAgentParseException(String message) {
        super(message);
    }

}
