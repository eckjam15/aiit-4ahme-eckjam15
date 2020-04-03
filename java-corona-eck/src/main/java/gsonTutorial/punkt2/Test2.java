/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsonTutorial.punkt2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author jakob
 */
public class Test2 {
    

//1. Default constructor
Gson gson = new Gson();
 
//2. Using GsonBuilder
Gson gson1 = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().serializeNulls().create();


}
