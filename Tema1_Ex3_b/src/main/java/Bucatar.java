public class Bucatar extends Thread {
    private final Oala oala;
    private boolean gataMasa;
    private final int idBucatar;

    public Bucatar(Oala oala, int idBucatar) {
        this.oala = oala;
        this.gataMasa = false;
        this.idBucatar = idBucatar;
    }

    public void gataMasa() {
        gataMasa = true;
        oala.setNrPortiiRamase(-1);
        oala.unlock(idBucatar);
    }

    public void run() {
        while (!gataMasa) {
            while (oala.getNrPortiiRamase() == 0) {
                oala.lock(idBucatar);
            }
            oala.setNrPortiiRamase(oala.getCapacitate());
            System.out.println("\nBucatarul reumple oala.");
            oala.unlock(idBucatar);
        }
    }
}