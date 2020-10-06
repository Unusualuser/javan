package Practice_10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calc app = new Calc();
            app.setVisible(true);
        });
    }
}
