import javax.swing.*;
import java.awt.*;

public class GUITest {

    public static void main(String[] args) {
        new GUITest();
    }

    public GUITest() {
        EventQueue.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            CheckBoxTable cbt = new CheckBoxTable(1);

            cbt.addColumn();
            //cbt.addRow();

            JFrame frame = new JFrame("Testing");
            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(cbt));
            //cbt.addRow(new Object[]{5, true, true});

            JButton addRow = new JButton("+R");
            frame.add(addRow);
            addRow.addActionListener(e -> cbt.addRow());

            JButton addColumn = new JButton("+C");
            frame.add(addColumn);
            addColumn.addActionListener(e-> cbt.addColumn());
            //TableColumn column;
            //DefaultCellEditor editor = new DefaultCellEditor(new JTextField());
            //editor.setClickCountToStart(1);
            //column = cbt.getColumnModel().getColumn(0);
            //column.setCellEditor(editor);
            //cbt.removeColumn(1);

            //cbt.addMouseListener(new TableListener());

            frame.setSize(800,800);

            new TableRowContextMenu(cbt);

            //frame.pack();
            //frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}