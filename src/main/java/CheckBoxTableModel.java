import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.util.ArrayList;

public class CheckBoxTableModel extends DefaultTableModel {

    private ArrayList<Boolean> editable_rows;

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
        return column > 0 || editable_rows.get(row);
    }

    @Override
    public void addRow(Object[] rowData) {
        addRow(convertToVector(rowData));
        editable_rows.add(false);
    }

    @Override
    public void removeRow(int row) {
        dataVector.remove(row);
        fireTableRowsDeleted(row, row);
        editable_rows.remove(row);
    }

    public void setCellEditable(int row, int col, Boolean isEditable) {
        editable_rows.set(row, isEditable);
    }

}