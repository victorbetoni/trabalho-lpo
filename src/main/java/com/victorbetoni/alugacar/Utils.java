/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Stream;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author VictorHugoBetoni
 */
public class Utils {
    
    public static final NumberFormat MOEDA_FORMAT;
    public static final NumberFormatter MOEDA_FORMATTER;
    
    static {
        MOEDA_FORMAT = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        MOEDA_FORMAT.setMinimumFractionDigits(2);
        MOEDA_FORMATTER = new NumberFormatter(MOEDA_FORMAT);
        MOEDA_FORMATTER.setValueClass(Double.class);
        MOEDA_FORMATTER.setAllowsInvalid(false);
        MOEDA_FORMATTER.setMinimum(0.0);
    }
        
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
    
    public static String formatarMoeda(double numero) {
        return MOEDA_FORMAT.format(numero);
    }
    
}
