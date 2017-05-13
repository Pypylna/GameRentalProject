package GUI;

import javax.swing.*;
import Entity.Game;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WAdding extends JFrame implements ActionListener {

    private JLabel titleLabel, nameLabel, worthLabel;
    private JTextField nameTextField ;
    private JFormattedTextField worthTextField;
    private JButton addButton;

    WAdding() {
        setSize(500, 500);
        setTitle("Game Rental - Adding game");
        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        titleLabel = new JLabel("Add game");
        nameLabel = new JLabel("Name");
        nameTextField = new JTextField();
        worthLabel = new JLabel("Worth");
        worthTextField = new JFormattedTextField();
        worthTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        addButton = new JButton("Dodaj");
        addButton.addActionListener(this);

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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton))

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
                		              	.addComponent(worthTextField)
                                        .addComponent(addButton))
		            )))

        ;

        //TODO Dodać odpowiednie pola tekstowe i etykiety do wpisywania danych do bazy
    }
    @Override
    public void actionPerformed(ActionEvent e){
    Object source = e.getSource();

        if(source==addButton) {
        	Game newGame = new Game();
        	newGame.setName(nameTextField.getText());
        	newGame.addGameToDb();
        	System.out.println("costam");
//        	newGame.setWorth(worthTextField.getText().toFloat());
        	
        	
            WAdding wAdding = new WAdding();
            wAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            wAdding.setVisible(true);
        }
    }
}
