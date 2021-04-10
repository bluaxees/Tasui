import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class TableRowListener implements PopupMenuListener {

    JTable table;

    TableRowListener(JTable table) {
        this.table = table;
    }

    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        SwingUtilities.invokeLater(() -> {

            table.clearSelection();
            JPopupMenu popupMenu = (JPopupMenu) e.getSource();
            int row = table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), table));
            int col = table.columnAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), table));

            if (row >= 0 && col == 0) {
                table.setColumnSelectionAllowed(false);
                table.setCellSelectionEnabled(true);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.changeSelection(row, 0,false, false);
            }

            else if (row <= 0 && col > 0) {
                table.setCellSelectionEnabled(false);
                table.setColumnSelectionAllowed(true);
                table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                table.setColumnSelectionInterval(col,col);
            }

        });
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) { }

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) { }

}
