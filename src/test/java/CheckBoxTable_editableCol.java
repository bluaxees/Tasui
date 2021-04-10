import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckBoxTable_editableCol extends JTable {

    private static CheckBoxTableModel model = new CheckBoxTableModel();

    static String DEFAULT_CHECKBOX_COlUMN_NAME = "Week";
    static String DEFAULT_ROW_IDENTIFIER_TITLE = "Courses";

    private JTableHeader header;
    private TableColumn column;
    private JTextField text;
    private JPopupMenu renamePopup;

    public CheckBoxTable_editableCol(int numColumn) {

        super(model);
        String[] titleRow = new String[numColumn + 1];
        titleRow[0] = DEFAULT_ROW_IDENTIFIER_TITLE;
        for (int i = 1; i < numColumn + 1; i++) {
            titleRow[i] = DEFAULT_CHECKBOX_COlUMN_NAME + " " + i;
        }

        model.setColumnIdentifiers(titleRow);
        this.getTableHeader().setReorderingAllowed(false);
        model.updateColumnSize(numColumn + 1);

        header = this.getTableHeader();
        header.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event)
            {
                if (event.getClickCount() == 2)
                {
                    editColumnAt(event.getPoint());
                }
            }
        });

        text = new JTextField();
        text.setBorder(null);
        text.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                renameColumn();
            }
        });

        renamePopup = new JPopupMenu();
        renamePopup.setBorder(new MatteBorder(0, 1, 1, 1, Color.DARK_GRAY));
        renamePopup.add(text);

        //addListener(this);


    }



    public CheckBoxTable_editableCol(String[] tableRow) {
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
        if (getRowCount() > 0)
            columnData = new Object[getRowCount() - 1];
        else
            columnData = new Object[0];
        String columnName = DEFAULT_CHECKBOX_COlUMN_NAME + " " +
                model.getLastKnownColumnSize();
        for (Object c: columnData) { c = false; }

        model.addColumn(columnName, columnData);
        model.updateColumnSize(0);

    }

    public void removeRow(int row) { model.removeRow(row); }

    public void removeColumn(int col) { model.removeColumn(col); }

    private void editColumnAt(Point p) {
        int columnIndex = header.columnAtPoint(p);

        if (columnIndex != -1)
        {
            column = header.getColumnModel().getColumn(columnIndex);
            Rectangle columnRectangle = header.getHeaderRect(columnIndex);

            text.setText(column.getHeaderValue().toString());
            renamePopup.setPreferredSize(
                    new Dimension(columnRectangle.width, columnRectangle.height - 1));
            renamePopup.show(header, columnRectangle.x, 0);

            text.requestFocusInWindow();
            text.selectAll();
        }
    }

    private void renameColumn()
    {
        column.setHeaderValue(text.getText());
        renamePopup.setVisible(false);
        header.repaint();
    }

}
