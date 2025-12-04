
/**
 * Write a description of class InputHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;

public class InputHandler
{
    private Scanner scanner;
    
    public InputHandler() {
        scanner = new Scanner(System.in);
    }
    
    public Set<String> captureWords() {
        System.out.println(">>> ");
        String line = scanner.nextLine().toLowerCase();
        
        return Arrays.stream(line.split("\\s+")).filter(word -> !word.isEmpty()).collect(Collectors.toSet());
    }
}