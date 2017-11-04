import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by joacim on 2017-10-25.
 */
public class MouseDemo extends JFrame implements ActionListener {


    private final JPanel panel = new JPanel(new BorderLayout());
    private final JPanel options = new JPanel(new FlowLayout());
    private static final JPanel buttonPanel = new JPanel();
    private final JButton newgame = new JButton("New Game");


    final JButton b1 = new JButton("1");
    final JButton b2 = new JButton("2");
    final JButton b3 = new JButton("3");
    final JButton b4 = new JButton("4");
    final JButton b5 = new JButton("5");
    final JButton b6 = new JButton("6");
    final JButton b7 = new JButton("7");
    final JButton b8 = new JButton("8");
    final JButton b9 = new JButton("9");
    final JButton b10 = new JButton("10");
    final JButton b11 = new JButton("11");
    final JButton b12 = new JButton("12");
    final JButton b13 = new JButton("13");
    final JButton b14 = new JButton("14");
    final JButton b15 = new JButton("15");
    JButton blanc = new JButton(" ");

    private static final List<JButton> buttons = new ArrayList<>();


    private MouseDemo() {
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);
        buttons.add(b10);
        buttons.add(b11);
        buttons.add(b12);
        buttons.add(b13);
        buttons.add(b14);
        buttons.add(b15);
        buttons.add(blanc);

        for (JButton b : buttons) {
            b.addActionListener(this);
            buttonPanel.add(b);
        }


        newgame.addActionListener(this);
        options.add(newgame);


        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setPreferredSize(new Dimension(420, 420));
        buttonPanel.setBackground(Color.ORANGE);
        panel.add("North", options);
        panel.add("South", buttonPanel);
        add(panel);

        setSize(500, 500);
        setLocation(350, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] arg) {
        MouseDemo m = new MouseDemo();
        ShuffleUtil.shuffle(buttons, buttonPanel);


    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newgame)
            ShuffleUtil.shuffle(buttons, buttonPanel);


        for (JButton b : buttons) {


            int buttonIndex = buttons.indexOf(b);
            int indexOfBlanc = buttons.indexOf(blanc);

            if (e.getSource() == b) {

                if (buttonIndex == indexOfBlanc + 1 || buttonIndex == indexOfBlanc + 4 ||
                        buttonIndex == indexOfBlanc - 1 || buttonIndex == indexOfBlanc - 4) {


                    blanc.setText(b.getText());
                    b.setText("");
                    blanc = b;
                    won();

                }
            }
        }
    }


    public void won() {

        boolean buttonInWrongPlace = false;
        int count = 1;

        for (JButton b : buttons) {
            String str = Integer.toString(count);
            count++;
            if (b.getText().equals(blanc.getText())) {
                if (count == 16) {
                    JOptionPane.showMessageDialog(null, "GRATTIS");
                    break;
                }
            }
        }
    }
}




