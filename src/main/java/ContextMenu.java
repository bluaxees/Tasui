import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public abstract class ContextMenu extends JPopupMenu {

    public JComponent table;

    // abstract void addMouseListener(MouseAdapter m);
    public void addMenuItem(String name, ActionListener listener) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(listener);
        this.add(menuItem);
    };

}
