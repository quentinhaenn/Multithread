package boiteAuLettre;


public class ThreadEcrivain extends Thread{

    private String message;
    private final Buffer buffer;
    private final long period;

    public ThreadEcrivain(String nom, String message, Buffer buffer, long period){
        super(nom);
        this.buffer = buffer;
        this.message = message;
        this.period = period;
    }

    public void run(){
        buffer.getLock().lock();

            while (buffer.getMessages().size() == buffer.getMaxLength()) {
                try {
                    buffer.getEmpty().await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            message ="numéro d'instance :" + String.valueOf(buffer.getMessages().size());
            buffer.getMessages().add(message);
            System.out.println(this.getName() + "Ajout de " + message + "dans la boite ... \n" +
                               "------------------------------------\n");
            buffer.getFull().signalAll();
            buffer.getLock().unlock();

    }

}
