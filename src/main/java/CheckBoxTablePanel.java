import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CheckBoxTablePanel extends JPanel {

    private GridBagConstraints gbc;
    private CheckBoxTable cbt;

    private static String DEFAULT_PANEL_TITLE = "Weekly Tracker";

    CheckBoxTablePanel (int col) {

        super(new GridBagLayout());
        gbc = new GridBagConstraints();
        cbt = new CheckBoxTable(col);

        gbc.insets = new Insets(2,2,1,2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton addRow = new JButton("Add " + cbt.DEFAULT_ROW_IDENTIFIER_TITLE);
        this.add(addRow, gbc);
        addRow.addActionListener(e -> cbt.addRow());

        gbc.gridy++;
        JButton addColumn = new JButton("Add " + cbt.DEFAULT_CHECKBOX_COlUMN_NAME);
        this.add(addColumn, gbc);
        addColumn.addActionListener(e-> cbt.addColumn());

        gbc.insets = new Insets(2,15,2,15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx++;
        gbc.gridy = 0;
        JScrollPane scrollPane = new JScrollPane(cbt);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(scrollPane, gbc);

        new TableRowContextMenu(cbt);

        TitledBorder title = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black), DEFAULT_PANEL_TITLE);
        title.setTitleJustification(TitledBorder.LEFT);
        this.setBorder(title);

    }

}
