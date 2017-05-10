package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WAdministratorPanel extends JFrame implements ActionListener {
    private JButton bAdd, bSearch;

    public WAdministratorPanel() {
        setSize(1000, 500);
        setTitle("Game Rental");
        setLayout(null);
    }
        @Override
        public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

            if(source==bAdd) {
            }
            else if(source==bSearch) {
            }
        }

}
