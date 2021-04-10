import javax.swing.*;

class TableRowContextMenu extends ContextMenu {

    CheckBoxTable table;

    public TableRowContextMenu(CheckBoxTable table) {

        this.table = table;
        this.table.setComponentPopupMenu(this);

        addMenuItem("Delete", e -> {
            int row = table.getSelectedRow();
            table.removeRow(row);
        });

        //after editatCell ends
        addMenuItem("Edit", e -> {
            int row = table.getSelectedRow();
            table.getModel().setCellEditable(row, 0, true);

            if (table.editCellAt(row, 0)) {

                JTextField editor = (JTextField) table.getEditorComponent();
                editor.requestFocusInWindow();
                editor.selectAll();
                // System.out.println(editor.getClass().getSimpleName());
                /*
                if (editor instanceof JFormattedTextField) {
                    ((JFormattedTextField) editor).select(0,
                            ((JFormattedTextField) editor).getText().length());
                } else if (editor instanceof JTextField) {
                    ((JTextField) editor).selectAll();
                }
                */
            }
            table.getModel().setCellEditable(row, 0, false);

        });

        this.addPopupMenuListener(new TableRowListener(this.table));

    }

}