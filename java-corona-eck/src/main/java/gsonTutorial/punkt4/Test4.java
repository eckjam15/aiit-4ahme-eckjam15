/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsonTutorial.punkt4;

import com.google.gson.Gson;
import gsonTutorial.punkt1_1.Test1;

/**
 *
 * @author jakob
 */
public class Test4 {

    public static void main(String[] args) {
        
        Gson gson = new Gson();
        System.out.println(gson.fromJson("{'id':1,'firstName':'Lokesh','lastName':'Gupta','roles':['ADMIN','MANAGER']}", Test1.class)); 
    }
            
}
