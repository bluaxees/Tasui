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
            JPopupMenu popupMenu = (JPopupMenu)e.getSource();
            int row = table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), table));
            if (row >= 0) {
                table.setRowSelectionInterval(row, row);
            }
        });
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) {
        // TODO Auto-generated method stub

    }
}
