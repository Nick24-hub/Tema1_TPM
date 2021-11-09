public class Salbatic extends Thread {
    private final Oala oala;
    private final int nrIteratii;
    private final int idSalbatic;

    public Salbatic(Oala oala, int nrIteratii, int idSalbatic) {
        this.oala = oala;
        this.nrIteratii = nrIteratii;
        this.idSalbatic = idSalbatic;
    }

    public void run() {
        int counter = 0;
        while (counter < nrIteratii) {
            while (true) {
                oala.lock(idSalbatic);
                if (oala.getNrPortiiRamase() == 0) {
                    oala.unlock(idSalbatic);
                } else {
                    oala.setNrPortiiRamase(oala.getNrPortiiRamase() - 1);
                    System.out.println("Salbaticul " + idSalbatic + " mananca o portie.");
                    oala.unlock(idSalbatic);
                    counter++;
                    break;
                }
            }
        }
    }
}
