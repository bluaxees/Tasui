import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckBoxTable extends JTable {

    private static CheckBoxTableModel model = new CheckBoxTableModel();

    static String DEFAULT_CHECKBOX_COlUMN_NAME = "Week";
    static String DEFAULT_ROW_IDENTIFIER_TITLE = "Courses";

    public CheckBoxTable(int numColumn) {

        super(model);
        String[] titleRow = new String[numColumn + 1];
        titleRow[0] = DEFAULT_ROW_IDENTIFIER_TITLE;
        for (int i = 1; i < numColumn + 1; i++) {
            titleRow[i] = DEFAULT_CHECKBOX_COlUMN_NAME + " " + i;
        }

        model.setColumnIdentifiers(titleRow);
        this.getTableHeader().setReorderingAllowed(false);


        this.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = ((JTableHeader)e.getSource()).getTable().columnAtPoint(e.getPoint());
                System.out.println(col);
            }
        });

        //addListener(this);

    }

    public CheckBoxTable(String[] tableRow) {
        super(model);
        model.setColumnIdentifiers(tableRow);

    }

    public CheckBoxTableModel getModel() {
        return model;
    }

    public void addRow() {

        Object[] rowData = new Object[getColumnCount()];
        rowData[0] = "";
        for (Object c: rowData) {
            if (c != null) { continue; }
            c = false;
        }

        model.addRow(rowData);

    }

    public void addColumn() {

        Object[] columnData;
        if (getRowCount() > 0) {
            columnData = new Object[getRowCount() - 1];
        }
        else {
            columnData = new Object[0];
        }
        String columnName = DEFAULT_CHECKBOX_COlUMN_NAME + " " + getColumnCount();

        for (Object c: columnData) {
            c = false;
        }

        model.addColumn(columnName, columnData);

    }

    public void removeRow(int rowIdx) { model.removeRow(rowIdx); }

    public void removeColumn(int colIdx) {
        this.removeColumn(this.getColumn(
                DEFAULT_CHECKBOX_COlUMN_NAME + " " + colIdx));
    }

}
