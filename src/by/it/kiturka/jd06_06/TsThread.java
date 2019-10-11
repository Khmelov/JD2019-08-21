package by.it.kiturka.jd06_06;

public class TsThread extends Thread {
    TsThread(int number) {
        super("TsThread" + number);
    }

    @Override
    public void run() {
        Logger.getLogger().writeStr(this.getName());
    }
}
