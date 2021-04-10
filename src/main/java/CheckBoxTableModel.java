import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class CheckBoxTableModel extends DefaultTableModel {

    private int lastKnownColumnSize = 1;

    public CheckBoxTableModel() {
        super(new String[] {""}, 1);
    }

    public CheckBoxTableModel(String[] titleRow) {
        super(titleRow, 0);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class class_ = String.class;
        if (columnIndex > 0 ) {
            return Boolean.class;
        }
        return class_;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    public void removeColumn(int col) {
        columnIdentifiers.remove(col);
        for (Object row: dataVector) {
            ((Vector)row).remove(col);
        }
        fireTableStructureChanged();
    }

    public void updateColumnSize(int col) {
        if (col == 0)
            lastKnownColumnSize++;
        else
            lastKnownColumnSize = col;
    }

    public int getLastKnownColumnSize() { return lastKnownColumnSize; }

}