package GUI;

import javax.swing.*;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionListener;

public class WAdding extends JFrame {

    private JLabel lItem;
    private JTextField tItem;

    WAdding() {
        setSize(500, 500);
        setTitle("Game Rental - Adding game");
        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        
        JLabel titleLabel = new JLabel("Add game");
        JLabel nameLabel = new JLabel("Name");
        JTextField	nameTextField = new JTextField();
        JLabel worthLabel = new JLabel("Worth");
        JTextField	worthTextField = new JTextField();

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            		.addComponent(titleLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                	.addComponent(nameTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(worthLabel)
                    .addComponent(worthTextField))

        );

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            			.addComponent(titleLabel)
                    	.addGroup(layout.createSequentialGroup()
                    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		                .addComponent(nameLabel)
                		                .addComponent(worthLabel))
                		        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		            	.addComponent(nameTextField)
                		              	.addComponent(worthTextField))
		            )))

        ;

        //TODO Dodać odpowiednie pola tekstowe i etykiety do wpisywania danych do bazy
    }
}
