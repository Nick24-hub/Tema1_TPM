import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final int capacitateOala = 3;
    private static final int nrSalbatici = 8;
    private static final int nrIteratii = 1;

    public static void main(String[] args) throws InterruptedException {
        Oala oala = new Oala(capacitateOala, nrSalbatici+1);
        Bucatar bucatar = new Bucatar(oala, nrSalbatici);
        bucatar.start();
        List<Salbatic> listaSalbatici = new ArrayList<>();
        for (int i = 0; i < nrSalbatici; ++i) {
            listaSalbatici.add(new Salbatic(oala, nrIteratii, i));
            listaSalbatici.get(i).start();
        }
        for (Salbatic x : listaSalbatici) {
            x.join();
        }
        bucatar.gataMasa();
        bucatar.join();
    }
}
