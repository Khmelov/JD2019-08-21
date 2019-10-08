package by.it.akhrem.jd02_06;

public class TsThread extends Thread {
    TsThread(int number) {
        super("TsThread" + number);
    }

    @Override
    public void run() {
        Logger.getLogger().writeStr(this.getName());
    }
}
