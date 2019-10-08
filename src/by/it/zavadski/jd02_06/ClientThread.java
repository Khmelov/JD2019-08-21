package by.it.zavadski.jd02_06;

import static by.it.zavadski.jd02_06.Logger.*;

public class ClientThread extends Thread{
    ClientThread(int number){
        super("Client Thread"+number);
    }

    @Override
    public void run() {
            getLogger().log(this.getName());
    }
}