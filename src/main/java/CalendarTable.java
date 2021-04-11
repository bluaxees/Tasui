import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CalendarTable extends JTable {

    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private Border bottomBorder = new MatteBorder(0, 0, 1, 0, Color.black);

    CalendarTable(DefaultTableModel model) {
        super(model);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        int modelRow = convertRowIndexToModel(row);
        int modelColumn = convertColumnIndexToModel(column);
        if (!isRowSelected(modelRow)) {
            if (modelRow > 0) {
                ((JComponent)c).setBorder(emptyBorder);
            } else {
                ((JComponent)c).setBorder(bottomBorder);
            }
        }
        return c;

    }
}
