import java.awt.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CalendarModel extends JPanel {

    protected int month;
    protected int year;

    protected String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
            "Aug", "Sep", "Oct", "Nov", "Dec" };
    protected String[] dayNames = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    CalendarTable table;
    Calendar calendar = Calendar.getInstance();
    JLabel yearMonthLabel = new JLabel(" ", SwingConstants.CENTER);
    GridBagConstraints constraints = new GridBagConstraints();

    public CalendarModel(int month, int year) {

        super(new GridBagLayout());
        setBackground(Color.WHITE);

        constraints.weighty = 0.0;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        this.month = month;

        table = new CalendarTable(new DefaultTableModel(7, 7));
        table.setShowGrid(false);
        updateDayNames();

        updateCalendarHeader();
        this.add(yearMonthLabel, constraints);
        // updateDayNames();
        updateDayNumbers();
        this.add(table, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JButton button = new JButton(">");
        this.add(button);
        button.addActionListener(e -> {
            createCalendar(this.month + 1, year);
            this.month++;
        });

    }

    public void createCalendar(int month, int year) {
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        updateCalendarHeader();
        // this.add(yearMonthLabel, constraints);
        updateDayNumbers();
        // this.add(table, constraints);
    }

    protected void updateDayNames() {

        for (int i = 0; i < dayNames.length; i++) {
            table.setValueAt(dayNames[i], 0, i);
        }

    }

    protected void updateDayNumbers() {

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int row = 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < daysInMonth; i++) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            table.setValueAt(i + 1, row, dayOfWeek - 1);
            if (dayOfWeek == 7) row ++;
            calendar.add(Calendar.DAY_OF_YEAR, +1);
        }

        constraints.gridy = 1;
        //this.add(table, constraints);

    }

    protected void updateCalendarHeader() {

        // JPanel titlePanel = new JPanel(true);
        // titlePanel.setBorder(BorderFactory.createEmptyBorder());
        // titlePanel.setLayout(new FlowLayout());
        // titlePanel.setBackground(Color.WHITE);

        yearMonthLabel.setText(monthNames[calendar.get(Calendar.MONTH)] + " " +
                calendar.get(Calendar.YEAR));
        // label.setBorder(new MatteBorder(1, 1, 1, 1, Color.gray));
        // label.setBackground(Color.white);
        // this.add(yearMonthLabel, constraints);

    }

    public void changeMonth(int field) {

    }

}