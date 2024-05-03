package statsVisualiser.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Observer.Subject;
import Observer.Viewer;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.util.ArrayList;

public class MainUI extends JFrame implements ActionListener, Subject {  

	private JPanel contentPane;
	public String sc;
	private static ArrayList<Object> viewSelected;

	public static ArrayList<Object> getViewSelected() {
		return viewSelected;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setTitle("Country Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1211, 645);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox<String> cbCountries = new JComboBox();
		cbCountries.setBounds(357, 8, 128, 40);
		cbCountries.setToolTipText("");
		cbCountries.setMaximumRowCount(195);
		contentPane.add(cbCountries);
		cbCountries.addItem("");


		for (List<String> line : Countries.Countires()) {

			String country = "";
			for (String value : line) {
				country = value;
				cbCountries.addItem(country);
				//System.out.println(value);
			

			}
		}
	    
		

		JLabel lblFromYear = new JLabel("From");
		lblFromYear.setBounds(505, 12, 44, 26);
		lblFromYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblFromYear);

		final JComboBox cbFromYear = new JComboBox();
		cbFromYear.setBounds(557, 8, 81, 40);
		contentPane.add(cbFromYear);
		cbFromYear.addItem("");
		cbFromYear.addItem("2010");
		cbFromYear.addItem("2011");
		cbFromYear.addItem("2012");
		cbFromYear.addItem("2013");
		cbFromYear.addItem("2014");
		cbFromYear.addItem("2015");
		cbFromYear.addItem("2016");
		cbFromYear.addItem("2017");
		cbFromYear.addItem("2018");
		cbFromYear.addItem("2019");
		cbFromYear.addItem("2020");
		cbFromYear.addItem("2021");
		cbFromYear.addItem("2022");

		JLabel lblToYear = new JLabel("To");
		lblToYear.setBounds(668, 12, 44, 26);
		lblToYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblToYear);

		final JComboBox cbToYear = new JComboBox();
		cbToYear.setBounds(698, 8, 88, 40);
		contentPane.add(cbToYear);
		cbToYear.addItem("");
		cbToYear.addItem("2010");
		cbToYear.addItem("2011");
		cbToYear.addItem("2012");
		cbToYear.addItem("2013");
		cbToYear.addItem("2014");
		cbToYear.addItem("2015");
		cbToYear.addItem("2016");
		cbToYear.addItem("2017");
		cbToYear.addItem("2018");
		cbToYear.addItem("2019");
		cbToYear.addItem("2020");
		cbToYear.addItem("2021");
		cbToYear.addItem("2022");

		JLabel lblAvaiViews = new JLabel("Available Views");
		lblAvaiViews.setBounds(29, 558, 120, 40);
		lblAvaiViews.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblAvaiViews);

		JComboBox cbAvaiViews = new JComboBox();
		cbAvaiViews.setBounds(149, 561, 155, 41);
		contentPane.add(cbAvaiViews);
		cbAvaiViews.addItem("");
		cbAvaiViews.addItem("Pie Chart");
		cbAvaiViews.addItem("Line Chart");
		cbAvaiViews.addItem("Bar Chart");
		cbAvaiViews.addItem("Scatter Chart");
		cbAvaiViews.addItem("Report");
		viewSelected.add(cbAvaiViews.getSelectedItem());

		JButton btnIncrease = new JButton("+");
		btnIncrease.setBounds(310, 565, 69, 35);
		btnIncrease.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnIncrease);

		JButton btnDecrease = new JButton("-");
		btnDecrease.setBounds(386, 565, 69, 35);
		btnDecrease.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnDecrease);

		JLabel lblChooseAnalysisMethod = new JLabel("Choose Analysis Method");
		lblChooseAnalysisMethod.setBounds(477, 558, 181, 40);
		lblChooseAnalysisMethod.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblChooseAnalysisMethod);

		final JComboBox cbAnalysis = new JComboBox();
		cbAnalysis.setBounds(654, 558, 296, 41);
		contentPane.add(cbAnalysis);
		cbAnalysis.addItem("");
		cbAnalysis.addItem("Energy use vs PM2.5 air pollution");
		cbAnalysis.addItem("Forest area vs PM2.5 air pollution");
		cbAnalysis.addItem("Current health expenditure per capita (current US$) - average"); //pie chart 
		cbAnalysis.addItem("CO2 emissions vs GDP per capita - ratio");
		cbAnalysis.addItem("Mortality rate,infant  vs Hospital beds - ratio");
		cbAnalysis.addItem("Forest area - average"); //pie chart 
		cbAnalysis.addItem("Government expenditure on education - average"); //pie chart
		cbAnalysis.addItem("Maternal mortality ratio vs Mortality rate, infant");

		JButton btnRecalculate = new JButton("Recalculate");
		btnRecalculate.setBounds(975, 556, 199, 44);
		btnRecalculate.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnRecalculate);
		btnRecalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String selectedCountry = cbCountries.getItemAt(cbCountries.getSelectedIndex());
            Object selectedFromYear = cbFromYear.getItemAt(cbFromYear.getSelectedIndex());
            Object selectedToYear = cbToYear.getItemAt(cbToYear.getSelectedIndex());
            Object selectedAnalysis = cbAnalysis.getItemAt(cbAnalysis.getSelectedIndex());
            System.out.println(" printing " + selectedCountry +" "+selectedFromYear +" "+selectedToYear + " "+selectedAnalysis);
            GetData getData = new GetData();
            try {
				getData.fetchData(selectedCountry,selectedFromYear,selectedToYear,selectedAnalysis);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
            }
        });
		JLabel lblChooseCountry = new JLabel("Choose a country:");
		lblChooseCountry.setBounds(222, 17, 128, 17);
		contentPane.add(lblChooseCountry);
		lblChooseCountry.setFont(new Font("Tahoma", Font.BOLD, 14));

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.controlDkShadow);
		desktopPane.setBounds(0, 0, 1195, 52);
		contentPane.add(desktopPane);

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(SystemColor.controlDkShadow);
		desktopPane_1.setBounds(0, 554, 1195, 52);
		contentPane.add(desktopPane_1);
	}
		public void actionPerformed(ActionEvent e) { 
			//String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
		    //code that reacts to the action... 
		}

		public void subscribe(Viewer viewer) {
			// TODO Auto-generated method stub
			
		}

		public void unSubscribe(Viewer viewer) {
			// TODO Auto-generated method stub
			
		}

		public void notifySubscriber() {
			// TODO Auto-generated method stub
			
		}
		
		
}
