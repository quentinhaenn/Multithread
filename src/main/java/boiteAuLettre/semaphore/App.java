package boiteAuLettre.semaphore;

import java.util.concurrent.Semaphore;

public class App {

    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(0);
        ThreadPerio threadPerio = new ThreadPerio("TH1",500,semaphore);
        ThreadSynchro threadSynchro = new ThreadSynchro(semaphore);

        threadPerio.start();
        threadSynchro.start();
    }

}
