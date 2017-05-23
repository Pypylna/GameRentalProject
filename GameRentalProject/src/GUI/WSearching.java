package GUI;

import javax.swing.*;
import Entity.Game;
import Validators.NumericValidator;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

public class WSearching extends JFrame implements ActionListener {

    private JLabel titleLabel, nameLabel, worthMaxLabel, worthMinLabel;
    private JTextField nameTextField ;
    private JTextField worthMaxTextField, worthMinTextField;
    private JButton searchButton;

    WSearching() {
        setSize(500, 500);
        setTitle("Game Rental - Searching for a game");
        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        
        titleLabel = new JLabel("Search by");
        nameLabel = new JLabel("Name");
        nameTextField = new JTextField();
        
        worthMaxLabel = new JLabel("Maximum worth");
        worthMaxTextField = new JTextField();
        worthMinLabel = new JLabel("Minimum worth");
        worthMinTextField = new JTextField();
        
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            		.addComponent(titleLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                	.addComponent(nameTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(worthMaxLabel)
                    .addComponent(worthMaxTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(worthMinLabel)
                    .addComponent(worthMinTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchButton))

        );

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            			.addComponent(titleLabel)
                    	.addGroup(layout.createSequentialGroup()
                    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		                .addComponent(nameLabel)
                		                .addComponent(worthMaxLabel)
                		                .addComponent(worthMinLabel))
                		        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		            	.addComponent(nameTextField)
                		              	.addComponent(worthMaxTextField)
                		              	.addComponent(worthMinTextField)
                                        .addComponent(searchButton))
		            )))

        ;

        //TODO DodaÄ‡ odpowiednie pola tekstowe i etykiety do wpisywania danych do bazy
    }
    @Override
    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	//TODO add acion and validation
//
//        if(source==searchButton) {
////        	System.out.println(worthTextField.getText());
//        	
////        	newGame.setWorth(worthTextField.getText().toFloat());
//        	//validation
//
//        	
//        	//walidacja danych
//        	if(NumericValidator.verifyAmount(worthTextField.getText())){
//        		
//        		//konwersja otrzymanych dane na dane do db
//        		String amountString = worthTextField.getText().replaceAll(",", ".");
//        		Float amount = Float.parseFloat(amountString);
//        		
//            	Game newGame = new Game();
//            	newGame.setName(nameTextField.getText());
//            	newGame.setWorth(amount);
//
//            	newGame.addGameToDb();
//            	JOptionPane.showMessageDialog(null,"Pozycja dodana do bazy danych");
//            	
//                WAdding wAdding = new WAdding();
//                wAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                wAdding.setVisible(true);
//        	}else{
//        		//#TODO lepsze notice'y
////            	System.out.println("informacja o b³êdzie w otrzymanych danych");
//            	JOptionPane.showMessageDialog(null,"Wprowadzone dane s¹ nieprawid³owe");
//        	}
//        	
//        }
    }
}



