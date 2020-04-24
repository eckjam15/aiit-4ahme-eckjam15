/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_Client_Stoppuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.RuntimeNode;




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
            
            if(handlers.size() == 3){
                serverSocket.close();
            }else{
                serverSocket.accept();
            }
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
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String req = reader.readLine();
                
                Gson gson = new Gson();
                Request r = gson.fromJson(req, Request.class);

                 if(r.isMaster()){
                    boolean setMasterTrue = true;
                    for(ConnectionHandler h : handlers){
                        if(h != this && h.isMaster() == true){
                            setMasterTrue = false;
                        }
                    }
                    master = setMasterTrue;
                }
                 
                 if(r.isStart()){
                     
                 }

                 if(r.isStop()){
                     startMillis = 0;
                 }else{
                     timeOffset = System.currentTimeMillis() - startMillis;
                 }
                 
                 if(r.isClear()){
                     timeOffset = 0;
                 }
                 
                 if(r.isEnd()){
                     socket.close();
                     handlers.remove(this);
                 }
                 
                 Response resp = new Response(master, r.isStop(), timeOffset);
                 
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}