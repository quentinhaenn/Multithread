package boiteAuLettre.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadSynchro extends Thread{

    private final Semaphore semaphore;

    public ThreadSynchro(Semaphore semaphore) {
        super("Thread Synchro");
        this.semaphore = semaphore;

    }

    public void run(){
        while(true){
            try{
                semaphore.acquire();
                System.out.println(this.getName() + "s'éxecute ! \n" +
                                   "----------------------------------\n");
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
