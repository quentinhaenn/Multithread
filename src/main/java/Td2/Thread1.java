package Td2;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Thread1 extends Thread {

    private Semaphore semaphore;
    private List<Integer> listInt;
    private int cpt;
    private long period;
    private int duration;


    public Thread1( final String nom, final Semaphore sem, final List<Integer> list, int cpt,
                    final long period, final int duration){
        super(nom);
        this.semaphore = sem;
        this.listInt = list;
        this.cpt = cpt ;
        this.period = period;
        this.duration = duration;
    }



}
