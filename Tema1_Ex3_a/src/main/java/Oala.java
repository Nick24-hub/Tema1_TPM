public class Oala {
    private final int capacitate;
    private volatile int nrPortiiRamase;

    public Oala(int capacitate) {
        this.capacitate = capacitate;
        this.nrPortiiRamase = 0;
    }

    public int getNrPortiiRamase() {
        return nrPortiiRamase;
    }

    public void setNrPortiiRamase(int nrPortiiRamase) {
        this.nrPortiiRamase = nrPortiiRamase;
    }

    public int getCapacitate() {
        return capacitate;
    }
}
