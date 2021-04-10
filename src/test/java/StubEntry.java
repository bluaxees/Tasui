import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StubEntry extends Column{

    private int size;
    //private ArrayList<String> stubEntries = new ArrayList<String>();
    private GridBagConstraints constraints = new GridBagConstraints();

    public StubEntry(int posX) {

        setLayout(new GridBagLayout());
        addEntry(new JTextField(""), posX);

    }

    public StubEntry(ArrayList<String> entries, int posX) {

        setLayout(new GridBagLayout());
        for (String entry : entries) {
            addEntry(new JTextField(entry), posX);
        }

    }

    @Override
    public void addEntry(JComponent entry, int gridPos) {

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0.5;
        constraints.gridx = gridPos;
        constraints.gridy = size;

        add(entry, constraints);
        size++;
        //stubEntries.add(entry);

    }
}
