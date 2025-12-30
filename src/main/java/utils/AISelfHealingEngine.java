package utils;

/**
 * @author: Kedarnath Lute
 # Auto-recover from known failures without human intervention
 */
import java.nio.file.*;
import java.io.IOException;

public class AISelfHealingEngine {

    public static void main(String[] args) throws IOException {
        String prediction = Files.readString(Path.of(args[0])).toLowerCase();

        if (prediction.contains("infra_timeout")) {
            System.out.println("ACTION=RETRY");
        }
        else if (prediction.contains("service_down")) {
            System.out.println("ACTION=RESTART_SERVICE");
        }
        else {
            System.out.println("ACTION=ABORT");
        }
    }
}
