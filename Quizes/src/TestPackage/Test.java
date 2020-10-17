/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author paterne
 */
public class Test {
    public static void main(String[] args){
        ArrayList<Object> list;
        list = new ArrayList<>();
        
        list.add(new DatabaseConfiguration.Levels());
        list.add("there");
        list.add(12);
        System.out.println(list);
        System.out.println(list.getClass());
    }
}
