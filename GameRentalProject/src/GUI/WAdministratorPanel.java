package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WAdministratorPanel extends JFrame implements ActionListener {
    private JButton bAdd, bSearch;

    public WAdministratorPanel() {
        setSize(500, 500);
        setTitle("Game Rental");
        setLayout(null);

        //Add new item to the data base
        bAdd = new JButton("Add new position");
        bAdd.setBounds(20, 30, 300, 50);
        add(bAdd);
        bAdd.addActionListener(this);

        //Search for the item in data base
        bSearch = new JButton("Search for the position");
        bSearch.setBounds(20, 90, 300, 50);
        add(bSearch);
        bSearch.addActionListener(this);
    }
        @Override
        public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

            if(source==bAdd) {
                WAdding wAdding = new WAdding();
                wAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                wAdding.setVisible(true);
            }
            else if(source==bSearch) {
            	WSearching wSearching = new WSearching();
            	wSearching.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	wSearching.setVisible(true);
                
            	//TODO: 2017-05-10
            }
        }

}
