package TableModels;
import javax.swing.table.*;
import Entity.Game;
import java.util.List;

public class GameTableModel extends AbstractTableModel{

	private List<Game> games = null;
    private final static Object[] columnNames = {"Id", "Name", "Worth"};
    private int[][] editedCells;
     
    private final static int ID_IDX = 0;
    private final static int NAME_IDX = 1;
    private final static int WORTH_IDX = 2;
 
    public GameTableModel() {}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		if(games==null) return 0;
        return games.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(games == null) return null;
        Game g = (Game) games.get(rowIndex);
        switch (columnIndex) {
            case ID_IDX:
                return g.getId();
            case NAME_IDX:
                return g.getName();
            case WORTH_IDX:
                return g.getWorth();
            default:
                return g;
        }
	}
	
    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }
 
    @Override
    public boolean isCellEditable(int row, int column) {
        return (row != ID_IDX);
    }
     
    public void setModelData(List<Game> games) {
       this.games =  games;
       editedCells = new int[this.getRowCount()][this.getColumnCount()];
    }
    
    public Game getGame(int position) {
        return games.get(position);
    }
    
    public void setValueAt(Object value, int row, int column) {
    	if( column == NAME_IDX)
    		games.get(row).setName((String)value);
    	if( column == WORTH_IDX)
    		games.get(row).setWorth((Float)value);
    	editedCells[row][column] = 1;
      }
    
    public int[] getEditedGamesIds(){
    	int[] array = new int[this.getRowCount()];
    	
    	for(int i=0; i < this.getRowCount(); i++){
    		for(int j=1; j < this.getColumnCount(); j++){
    			if(editedCells[i][j] == 1){
    				array[i] = getGame(i).getId();
    			}
    		}
    	}
    	
    	return array;
    }

}
