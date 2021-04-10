import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class CheckBoxTableModel extends DefaultTableModel {

    private ArrayList<Boolean> editable_rows;
    private int lastKnownColumnSize = 1;

    public CheckBoxTableModel() {
        super(new String[] {""}, 0);
        editable_rows = new ArrayList<Boolean>();
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

    public void setCellEditable(int row, int col, Boolean isEditable) {
        editable_rows.set(row, isEditable);
    }

}