public class Main {

    public static void main(String[] args) {
        int i = 0;
        Methods method = new Methods(i);
        Thread firstThread = new Thread(() -> {
                method.firstMethod();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Mistake");
            }
                System.out.println("First thread start");
        });
        Thread secondThread = new Thread(() -> {
            method.secondMethod();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Mistake");
            }
            System.out.println("Second thread start");
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            System.out.println("Mistake");
        }

        System.out.println(method.getI());
    }
}
