import java.io.*;
import java.net.URL;

// @links https://code.jquery.com/jquery-3.5.1.min.js

public class Download extends Thread {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    final String FILE_URL;

    public Download() throws IOException {
        System.out.println("Input link to the file");
        FILE_URL = bf.readLine();
    }

    @Override
    public void run() {
        download();
    }

    public void download() {
        try (BufferedInputStream bfDownload = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("file")) {
            byte[] buffer = new byte[1024];
            int count;

            while ((count = bfDownload.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
