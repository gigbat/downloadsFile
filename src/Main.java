import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Download download = new Download();
        Thread thread = new Thread(download);
        thread.start();

        ProgressBar progressBar = new ProgressBar();
        Thread thread1 = new Thread(progressBar);
        thread1.start();
    }
}
