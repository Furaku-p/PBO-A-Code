
/**
 * Write a description of class TechSupport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Set;

public class TechSupport
{
    private InputHandler inputHandler;
    private Keyword responder;
    
    public TechSupport() {
        inputHandler = new InputHandler();
        responder = new Keyword();
    }
    
    public void launch() {

        System.out.println("===== Academic Help Desk ITS =====");
        System.out.println("Laporkan kendala akademik Anda.");
        System.out.println("Ketik 'keluar' untuk menghentikan program.\n");

        boolean run = true;

        while (run) {
            Set<String> words = inputHandler.captureWords();
            if (words.contains("keluar")) {
                run = false;
            } else {
                String reply = responder.respond(words);
                System.out.println("Respon: " + reply + "\n");
            }
        }

        System.out.println("Terima kasih telah menggunakan Academic Help Desk.");
    }
    
    public static void main(String[] args) {
        TechSupport system = new TechSupport();
        system.launch();
    }
}