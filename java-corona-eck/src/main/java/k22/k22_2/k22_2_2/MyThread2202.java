/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_2.k22_2_2;

/**
 *
 * @author jakob
 */
public class MyThread2202 extends Thread{
    
    public void run(){
        int i = 0;
        while(true){
            System.out.println(i++);
        }
    }
}
