import javax.swing.*;
import java.awt.*;

public class CheckBoxRow extends Column{

    private int size;
    //private ArrayList<String> stubEntries = new ArrayList<String>();
    private GridBagConstraints constraints = new GridBagConstraints();

    public CheckBoxRow(int numColumns, int posY) {

        setLayout(new GridBagLayout());
        for (int i = 0; i < numColumns; i++) {
            addEntry(new JCheckBox(), posY);
        }

    }

    @Override
    public void addEntry(JComponent entry, int gridPos) {

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0.5;
        constraints.gridx = size;
        constraints.gridy = 0;

        add(entry, constraints);
        size++;

    }
}
