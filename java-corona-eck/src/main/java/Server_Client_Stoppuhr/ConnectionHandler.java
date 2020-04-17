/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_Client_Stoppuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author jakob
 */
    public class ConnectionHandler implements Runnable {
        
    private Socket socket;
    private boolean master;
    
    public ConnectionHandler(Socket socket){
        this.socket = socket;
    }
    
    public boolean isClosed(){
        return socket.isClosed();
    }
    
    public boolean isMaster(){
        return master;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReder(new InputStream);
        String line;
        
        try{
            line = reader.readLine();
        }catch(IOException ex){
            throw new IllegalArgumentException();
        }
        
        Gson gson = new Gson();
        gson.toJson(line);
    }
}
