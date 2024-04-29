import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(WordCounter::new);
        // To ensure Swing components are initialized on the Event Dispatch Thread
    }
}
