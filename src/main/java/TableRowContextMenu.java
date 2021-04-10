import javax.swing.*;

class TableRowContextMenu extends ContextMenu {

    CheckBoxTable table;

    public TableRowContextMenu(CheckBoxTable table) {

        this.table = table;
        this.table.setComponentPopupMenu(this);
        this.table.getTableHeader().setComponentPopupMenu(this);

        addMenuItem("Delete", e -> {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            if (row == -1) {
                table.removeColumn(col);
            }
            else if (row >= 0 && col == 0) {
                table.removeRow(row);
            }
        });

        addMenuItem("Edit", e -> {
            int row = table.getSelectedRow();

            if (table.editCellAt(row, 0)) {
                JTextField editor = (JTextField) table.getEditorComponent();
                editor.requestFocusInWindow();
                editor.selectAll();
            }

        });

        this.addPopupMenuListener(new TableRowListener(this.table));

    }

}