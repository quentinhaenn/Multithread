package boiteAuLettre;

public class ThreadLecteur extends Thread{

    private Buffer buffer;

    public ThreadLecteur(String name, Buffer buffer) {
        super(name);
        this.buffer = buffer;
    }

    public void run(){
        buffer.getLock().lock();

            while (buffer.getMessages().size() == 0){
                try {
                buffer.getFull().await();
            }catch (InterruptedException e){
                e.printStackTrace();
                }
            }
            String data = buffer.getMessages().remove(0);
            System.out.println("Lecture du message arrivé ! \n" +
                               data + "\n" +
                               "---------------------------\n");
            buffer.getEmpty().signalAll();
            buffer.getLock().unlock();
    }

}
