package boiteAuLettre;

public class App {
    public void main( String[] args){
        Buffer buffer = new Buffer(20);

        long period = 500;
        ThreadEcrivain TH1 = new ThreadEcrivain("TH1","",buffer, period);
        ThreadEcrivain TH2 = new ThreadEcrivain("TH2", "",buffer, period);
        ThreadLecteur TH3 = new ThreadLecteur("TH3", buffer);
        ThreadLecteur TH4 = new ThreadLecteur("TH4",buffer);

        TH1.start();
        TH2.start();
        TH3.start();
        TH4.start();



    }
}
