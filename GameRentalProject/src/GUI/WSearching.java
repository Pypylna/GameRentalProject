package GUI;

import javax.swing.*;

import Entity.Game;
import Repository.GameRepository;
import Validators.NumericValidator;
import TableModels.GameTableModel;

import javax.swing.table.*;

import java.util.List;
import java.util.ArrayList;

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
    private JTable gamesTable;
    private GameTableModel gameTModel;
    private JScrollPane scrollTable;

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
        
        gameTModel = new GameTableModel();
        gamesTable = new JTable(gameTModel);
        scrollTable = new JScrollPane(gamesTable);
        

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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(scrollTable))

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
                                        .addComponent(searchButton)
                                        .addComponent(scrollTable))
		            )))
        ;
        
        

        //TODO DodaÄ‡ odpowiednie pola tekstowe i etykiety do wpisywania danych do bazy
    }
    @Override
    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	float maxWorth;
    	float minWorth;
    	String name;
    	List<Game> games;

        if(source==searchButton) {
        	//walidacja danych
        	//TODO walidacja - opcja pustych danych, opcja max<min
        	if(NumericValidator.verifyAmount(worthMaxTextField.getText()) &&
        			NumericValidator.verifyAmount(worthMinTextField.getText())){
        		
        		//konwersja otrzymanych dane na dane do db
        		String maxWorthString = worthMaxTextField.getText().replaceAll(",", ".");
        		maxWorth = Float.parseFloat(maxWorthString);

        		String minWorthString = worthMinTextField.getText().replaceAll(",", ".");
        		minWorth = Float.parseFloat(minWorthString);
        		
        		name = nameTextField.getText();
        		
        		games = GameRepository.searchForGames(name, minWorth, maxWorth);
        		
        		gameTModel.setModelData(games);
        		gameTModel.fireTableDataChanged();
        		
        		
//                WAdding wAdding = new WAdding();
//                wAdding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                wAdding.setVisible(true);
        	}else{
//        		//#TODO lepsze notice'y
//            	System.out.println("informacja o b³êdzie w otrzymanych danych");
            	JOptionPane.showMessageDialog(null,"Wprowadzone dane s¹ nieprawid³owe");
        	}
        }
    }
}



