package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class WAdding extends JFrame {

    private JLabel lItem;
    private JTextField tItem;

    WAdding() {
        setSize(1000, 500);
        setTitle("Game Rental - Adding items");
        setLayout(null);

        //example of label
        lItem = new JLabel("NEW ITEM");
        lItem.setBounds(20, 20, 100, 50);
        add(lItem);

        //example of text field
        tItem = new JTextField("");
        tItem.setBounds(100, 20, 300, 50);
        add(tItem);

        //TODO Dodać odpowiednie pola tekstowe i etykiety do wpisywania danych do bazy
    }
}
