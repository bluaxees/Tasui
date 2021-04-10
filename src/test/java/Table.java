import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Table extends JPanel {

    public Table() {

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = 0.33;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        //constraints.insets = new Insets(4, 4, 4, 4);

        //add(new TRow(0,5,"Test"), constraints);
        //constraints.gridy++;

        ArrayList<String> gfg = new ArrayList<String>() {
            {
                add("A");
                add("B");
                add("C");
                add("D");
                add("E");
            }
        };
        StubEntry a = new StubEntry(0);
        add(a, constraints);
        a.addEntry(new JTextField("GG"),0);


        /*
        JButton button = new JButton("Button 1");

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Button 2");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Button 3");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 2;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Long-Named Button 4");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = -10;      //make this component tall
        //constraints.weightx = 0.0;
        constraints.gridwidth = 3;
        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(button, constraints);

        button = new JButton("5");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 0;       //reset to default
        constraints.weighty = 1.0;   //request any extra vertical space
        constraints.anchor = GridBagConstraints.PAGE_END; //bottom of space
        constraints.insets = new Insets(10,0,0,0);  //top padding
        constraints.gridx = 1;       //aligned with button 2
        constraints.gridwidth = 2;   //2 columns wide
        constraints.gridy = 2;       //third row
        frame.add(button, constraints);
        */

    }

}