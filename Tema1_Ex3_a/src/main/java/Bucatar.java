public class Bucatar extends Thread {
    private final Oala oala;
    private boolean gataMasa;

    public Bucatar(Oala oala) {
        this.oala = oala;
        this.gataMasa = false;
    }

    public void gataMasa() {
        synchronized (oala) {
            this.gataMasa = true;
            oala.setNrPortiiRamase(-1);
            oala.notifyAll();
        }
    }

    public void run() {
        synchronized (oala) {
            while (!gataMasa) {
                oala.setNrPortiiRamase(oala.getCapacitate());
                System.out.println("\nBucatarul reumple oala.");
                oala.notifyAll();
                while (oala.getNrPortiiRamase() > 0) {
                    try {
                        oala.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}