package downloads;

public class ProgressBar extends Thread {
    public void progress() throws InterruptedException {
        for (int i = 0; i < 101; i+=10) {
            System.out.println("Progress Bar......"+i+"%");
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        try {
            progress();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
