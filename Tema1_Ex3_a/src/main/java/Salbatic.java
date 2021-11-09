public class Salbatic extends Thread {
    private final Oala oala;
    private boolean gata;

    public Salbatic(Oala oala) {
        this.oala = oala;
        this.gata = false;
    }

    public void run() {
        synchronized (oala) {
            while (!gata) {
                while (oala.getNrPortiiRamase() == 0) {
                    try {
                        oala.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                oala.setNrPortiiRamase(oala.getNrPortiiRamase() - 1);
                System.out.println("Un salbatic mananca o portie.");
                gata = true;
                oala.notifyAll();
            }
        }
    }
}
