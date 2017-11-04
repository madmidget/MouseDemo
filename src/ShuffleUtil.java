import javax.swing.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by joacim on 2017-10-27.
 */
public class ShuffleUtil {

        static void shuffle(List<JButton> buttons, JPanel buttonPanel) {
        Collections.shuffle(buttons);
        for (JButton b : buttons) {
            buttonPanel.add(b);
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
}




