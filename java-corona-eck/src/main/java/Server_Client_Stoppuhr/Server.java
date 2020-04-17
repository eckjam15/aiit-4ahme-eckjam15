/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_Client_Stoppuhr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author jakob
 */
public class Server {
   
    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
    
    public void start(int port) throws IOException{
        
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        
        while(true){
            socket = serverSocket.accept();
            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            handlers.add(handler);
        }
    }
    
    public boolean isTimerRunning(){
        
    }
    
    public long getTimerMillis(){
        return timeOffset;
    }
    
    public static void main(String[] args) {
        new Server();
    }
    
}
