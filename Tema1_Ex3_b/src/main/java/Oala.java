public class Oala {
    private final int capacitate;
    private volatile int nrPortiiRamase;
    private final boolean[] intrat;
    private final int[] etichete;
    private final int nrSalbatici;

    public Oala(int capacitate, int nrSalbatici) {
        this.capacitate = capacitate;
        this.nrPortiiRamase = capacitate;
        this.intrat = new boolean[nrSalbatici];
        this.etichete = new int[nrSalbatici];
        this.nrSalbatici = nrSalbatici;
    }

    boolean etichetaMaiMare(int x, int y) {
        if (etichete[x] == etichete[y]) {
            return x > y;
        } else {
            return etichete[x] > etichete[y];
        }
    }

    private boolean altIntrat(int id) {
        for (int i = 0; i < nrSalbatici; ++i)
            if (id != i && intrat[i] && etichetaMaiMare(id, i))
                return true;
        return false;
    }

    public void lock(int id) {
        intrat[id] = true;
        int maxim = 0;
        for (int i = 0; i < nrSalbatici; i++) {
            maxim = Math.max(maxim, etichete[i]);
        }
        etichete[id] = 1 + maxim;
        while (altIntrat(id)) {
        }
    }

    public void unlock(int id) {
        intrat[id] = false;
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
