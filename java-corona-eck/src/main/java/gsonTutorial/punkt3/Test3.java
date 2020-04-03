/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsonTutorial.punkt3;

import com.google.gson.Gson;
import gsonTutorial.punkt1_1.Test1;
import java.util.Arrays;

/**
 *
 * @author jakob
 */
public class Test3 {
    
    public static void main(String[] args) {
        Test1 employee = new Test1();
        employee.setId(1);
        employee.setFirstName("Lokesh");
        employee.setLastName("Gupta");
        employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
 
        Gson gson = new Gson();
 
        System.out.println(gson.toJson(employee));
    }
}
