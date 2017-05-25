package TableModels;
import javax.swing.table.*;
import Entity.Game;
import java.util.List;

public class GameTableModel extends AbstractTableModel{

	private List<Game> games = null;
    private final static Object[] columnNames = {"Id", "Name", "Worth"};
     
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
        return false;
    }
     
    public void setModelData(List<Game> games) {
       this.games =  games;
    }
    public Game getGame(int position) {
        return games.get(position);
    }

}
