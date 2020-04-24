/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_Client_Stoppuhr;

/**
 *
 * @author jakob
 */
public class Response {
    private boolean master;
    private long count;
    private boolean running;
    private long time;

    public Response(boolean master, long count, boolean running, long time) {
        this.master = master;
        this.count = count;
        this.running = running;
        this.time = time;
    }

    Response(boolean master, boolean stop, long timeOffset) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean isMaster(){
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }
    
    public long isCount(){
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
    
    public boolean isRunning(){
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    public long isTime(){
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
