/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Kaveesha Nadun
 */
public class GenarateOTP {
    public static char[] getOTP(){
        String number ="0123456789";
        Random r = new SecureRandom();
        char[] otpcode = new char [6];
        for (int i = 0; i < otpcode.length; i++) {
            otpcode[i] = number.charAt(r.nextInt(number.length()));
        }
    return otpcode;
    }
}