package TripPlanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TripVisualizer extends JFrame {

	private JPanel contentPane;
	private JTextField startingField;
	private JTextField endingField;
	private JLabel lblTitle;
	private JComboBox<String> vehicleComboBox; 
	private JCheckBox cycleCheckBox;
	private TripPlanner trip;
	private TripVisualizer thisGui;
	private boolean isTravelling = false;
	private boolean isWaiting = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripVisualizer frame = new TripVisualizer();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TripVisualizer() {
		trip = TripPlannerApp.newTrip();
		thisGui = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		contentPane.add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		String title = "<html><pre>  __  __ _ _ _                  _       _   _____                 _ _        _       <br/>" + 
				" |  \\/  (_) | |                (_)     | | |  __ \\               | | |      (_)      <br/>" + 
				" | \\  / |_| | | ___ _ __  _ __  _  __ _| | | |__) |___   __ _  __| | |_ _ __ _ _ __  <br/>" + 
				" | |\\/| | | | |/ _ \\ '_ \\| '_ \\| |/ _` | | |  _  // _ \\ / _` |/ _` | __| '__| | '_ \\ <br/>" + 
				" | |  | | | | |  __/ | | | | | | | (_| | | | | \\ \\ (_) | (_| | (_| | |_| |  | | |_) |<br/>" + 
				" |_|  |_|_|_|_|\\___|_| |_|_| |_|_|\\__,_|_| |_|  \\_\\___/ \\__,_|\\__,_|\\__|_|  |_| .__/ <br/>" + 
				"                                                                              | |    <br/>" + 
				"                                                                              |_|   </pre></html>";
		
		lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblTitle, BorderLayout.CENTER);
		
		JPanel optionsPanel = new JPanel();
		contentPane.add(optionsPanel);
		optionsPanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel startingPanel = new JPanel();

		optionsPanel.add(startingPanel);
		FlowLayout fl_startingPanel = new FlowLayout(FlowLayout.CENTER, 5, 20);
		startingPanel.setLayout(fl_startingPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Starting Location");
		startingPanel.add(lblNewLabel_1);
		
		startingField = new JTextField();
		startingPanel.add(startingField);
		startingField.setColumns(10);
		
		JPanel endingPanel = new JPanel();
		optionsPanel.add(endingPanel);
		endingPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel lblEndingLocation = new JLabel("Ending Location");
		endingPanel.add(lblEndingLocation);
		
		endingField = new JTextField();
		endingPanel.add(endingField);
		endingField.setColumns(10);
		
		JPanel togglePanel = new JPanel();
		optionsPanel.add(togglePanel);
		togglePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel checkPanel = new JPanel();
		togglePanel.add(checkPanel);
		checkPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel cycleLabel = new JLabel("Cycle back to Start");
		checkPanel.add(cycleLabel);
		
		cycleCheckBox = new JCheckBox("");
		checkPanel.add(cycleCheckBox);
		
		JPanel vehiclePanel = new JPanel();
		togglePanel.add(vehiclePanel);
		vehiclePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel vehicleLabel = new JLabel("Vehicle Type");
		vehiclePanel.add(vehicleLabel);
		
		String[] comboStrings = {"Car", "Truck", "Motorcycle"};
		vehicleComboBox = new JComboBox<>(comboStrings);
		vehiclePanel.add(vehicleComboBox);
		
		JPanel startPanel = new JPanel();
		optionsPanel.add(startPanel);
		startPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JButton btnStartButton = startButton();
		startPanel.add(btnStartButton);
	}

	private JButton startButton() {
		JButton btnStartButton = new JButton("Start");
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isTravelling && isWaiting)
				{
					trip.setCheckForContinue(false);
				}
				else if (!isTravelling)
				{
					isTravelling = true;
					new TravelWorker().execute();
				}		
			}
		});
		return btnStartButton;
	}
	
	public void setIsWaiting(boolean bool)
	{
		isWaiting = bool;
	}

	
	public void updateTitle(String newTitle)
	{
		StringBuilder str = new StringBuilder("<html><pre>");
		str.append(newTitle);
		str.append("</pre></html>");
		lblTitle.setText(str.toString());
		contentPane.revalidate();
		contentPane.updateUI();
		contentPane.repaint();
	}

	class TravelWorker extends SwingWorker<Integer, Integer>
	{
	    protected Integer doInBackground() throws Exception
	    {
	    	trip.tripSetup(
					startingField.getText(), 
					endingField.getText(), 
					vehicleComboBox.getSelectedIndex(), 
					cycleCheckBox.isSelected(), 
					thisGui);
	    	return 42;
	    }

	    protected void done()
	    {
	        try
	        {
	            
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
}
