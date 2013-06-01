package ProjetJAVA;

/**
 *
 * @author Erza
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


/** class MCalendar prints a calendar of the current month (taken from the computer's clock).
    Opens a new window and prints each day as a text field placed inside of a GridBagLayout.
    The current day (from the computer's clock) is painted red.
  */

public class MCalendar extends JPanel
{
	private GridBagLayout		calendar_gridBagLayout = new GridBagLayout();
	private GridBagConstraints	constraints = new GridBagConstraints();
	private	Container		content = this;
	private	Border			border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
	private	static GregorianCalendar now = new GregorianCalendar();
    private JComboBox cb_mois = new JComboBox();


	public MCalendar()
	{
		this(now.get(Calendar.MONTH), now.get(Calendar.YEAR));
	}


	public MCalendar(int month)
	{
		this(month, now.get(Calendar.YEAR));
	}


	public MCalendar(int month, int year)
	{

        setLayout(calendar_gridBagLayout);
		// sets both the width and heigth of all objects to that
		// of the widest and the heighest displayed object

		constraints.fill = GridBagConstraints.BOTH;

		printHeader(month, year);
		paintDays();
		paintMonth(month, year);
	}
    



	private void addComponent(Component c, int row, int col) // adds a component to "calendar"
	{
		constraints.gridx = col;			// "constraints" is a global GridBagConstraints
		constraints.gridy = row;
		calendar_gridBagLayout.setConstraints(c, constraints);	// "calendar" is a global GridBagLayout
		content.add(c);
	}



	// Creates a JLabel object that has the month and year and is 7
	// columns wide.  The JLabel is placed in a JPanel, which is constrained
	// to 0,0 in the GridBagLayout.  A raised beveled border is put around the JPanel.

	private void printHeader(int month, int year)
	{
		String monthName[] = { "January",   "February",  "March",
					"April",    "May",       "June",
					"July",     "August",    "September",
					"October",  "November",  "December"
			 	     };

		JPanel header = new JPanel();
		header.add(new JLabel(monthName[month] + ", " + year, JLabel.CENTER));
		header.setBorder(border);

		constraints.gridwidth = 7;			// text field spans 7 columns
		addComponent(header, 0, 0);
		constraints.gridwidth = 1;			// reset width to 1 column
	}


	// Seven JLabel objects are created; each holds one day of the week.
	// Each JLabel is put in a JPanel, which has a raised beveled border.
	// Each JPanel is constrained to be at 1,0 through 1,6 and is added to
	// the GridBagLayout.

	private void paintDays()
	{
		String dayNames[] = {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam","Dim"};
		for (int i = 0; i < 7; i++)
		{	JPanel	day = new JPanel();
            editSize(day,100,50);
			day.add(new JLabel(dayNames[i], JLabel.CENTER));
			//day.setBorder(border);
			addComponent(day, 1, i);
		}
	}

	// One JLabel object is created for each day in the month.  Each JLabel is
	// placed in a JPanel.  The JPanel object corresponding to the
	// current date is highlighted (the background color is set to red
	// and the foreground color is set to white) if displaying the current month and year.
	// "day" is the day of the week on which the month begins.
	// Each JPane object is constrained at a location (row and column)
	// beginning at 2,day; the column "col" is incremented until it becomes
	// 7, at which time it is reset to 0 and the row "row" is incremented.

	private void paintMonth(int month, int year)
	{
		int			mon_len[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		GregorianCalendar	firstday = new GregorianCalendar(year, month, 1); // 1st day of the month
		int			date = 0;
		int			day = firstday.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
		int			row = 2;
		int			col = day-2;


		if (firstday.isLeapYear(year)){			// pretty obvious
			mon_len[1]++;
            System.out.println(mon_len[1]);
        }

		if (now.get(Calendar.YEAR) == year && now.get(Calendar.MONTH) == month){
			date = now.get(Calendar.DATE);
            System.out.println(date);
        }
        
		for (int k = 1; k < day; k++)				// blanks before first day of month
		{	JPanel blank = new JPanel();
            editSize(blank,100,100);
			blank.setBorder(border);
			addComponent(blank, row, k-2);
		}

		for (int k = 0; k < mon_len[month]; k++) // Colore le jour présent
		{	JPanel dayLabel = new JPanel();
            editSize(dayLabel,100,100);
			dayLabel.setBorder(border);

			if (date > 0 && k+1 == date)
			{	dayLabel.setBackground(Color.red);
				dayLabel.setForeground(Color.white);
			}

			dayLabel.add(new JLabel((k+1) + "", JLabel.CENTER));
			addComponent(dayLabel, row, col++);

			if (col == 7) 	
            {    col = 0;
				row++;
			}
		}

		for (int k = col; k < 7; k++)				// blanks after last day of month
		{	JPanel blank = new JPanel();
            editSize(blank,100,100);
			blank.setBorder(border);
			addComponent(blank, row, k);
		}
	}
    
    public void editSize(JPanel panel, int width, int height){
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
    }
    
    // Getter sur JPassword
    public JComboBox getJComboBox() {
    return cb_mois;
    } 
} // class MCalendar


