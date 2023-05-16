public class Methods {
    private int i;

    public Methods(int i) {
        this.i = i;
    }

    public synchronized void firstMethod() {
        while (i > 5) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        i += 10;
        notify();
    }

    public synchronized void secondMethod() {
        while (i < 10) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        i -= 5;
        notify();
    }

    public int getI() {
        return i;
    }
}
