/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar;

import java.util.stream.Stream;
import javax.swing.JTextField;

/**
 *
 * @author VictorHugoBetoni
 */
public class Utils {
    
    public static boolean allFilled(String... str) {
        return Stream.of(str).noneMatch(x -> x == null || x.trim().equals(""));
    }
    
    public static boolean isDouble(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
    
    public static void clearTextFields(JTextField... fields) {
        Stream.of(fields).forEach(x -> {
            x.setText("");
            x.updateUI();
        });
    }
    
}
