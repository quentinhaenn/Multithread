package boiteAuLettre.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadPerio extends Thread {

    private final long period;
    private final Semaphore semaphore;

    public ThreadPerio(String name, long period, Semaphore semaphore) {
        super(name);
        this.period = period;
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            try{
                System.out.println(this.getName()+" : s'exécute ! \n" +
                                   "-----------------------------");
                Thread.sleep(period);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }


}
