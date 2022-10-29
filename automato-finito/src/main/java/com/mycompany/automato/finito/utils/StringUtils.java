/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automato.finito.utils;

public class StringUtils {
    static public String addSubstringToString(String str, String subString, int position){
        return str.substring(0, position) + subString + str.substring(position) + "\n";
    }
}
