package br.edu.ifc.concordia.inf.swing;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CalculadoraDeGorjetas extends JFrame {

	private JPanel rootPanel;
	private JPanel mainPanel;
	private JButton calculateBtn;
	private GridLayout layout;
	
	private JList exampleList;
	private DefaultListModel<String> entries;
	
	private JTextField field_preco;
	private JSlider field_percentual;
	private JTextField field_gorjeta;
	private JTextField field_total;
	
	private JLabel label_preco;
	private JLabel label_percentual;
	private JLabel label_gorjeta;
	private JLabel label_total;
	
	public CalculadoraDeGorjetas(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 350);
		FlowLayout windowLayout = new FlowLayout();
		windowLayout.setHgap(10);
		windowLayout.setVgap(10);
		this.setLayout(windowLayout);
		CalculadoraDeGorjetas frame = this;
		
		rootPanel = new JPanel();
		entries = new DefaultListModel<String>();
		for (int i = 0; i< 10; i++) {
			entries.addElement("Sangaletti");
			entries.addElement("Batata");
			entries.addElement("Toca");
		}
		exampleList = new JList<String>(entries);
		exampleList.setPreferredSize(new Dimension(200, 500));
		JScrollPane scroller = new JScrollPane(exampleList);
		scroller.setPreferredSize(new Dimension(250, 250));
		scroller.setLocation(0, 0);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		rootPanel.add(scroller);
		
		
		mainPanel = new JPanel();
		layout = new GridLayout(5,2);
		layout.setHgap(10);
		layout.setVgap(10);
		mainPanel.setSize(500, 250);
		mainPanel.setLocation(300, 0);
		mainPanel.setLayout(layout);
		mainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		label_preco = new JLabel("Preço da Conta:");
		label_preco.setHorizontalAlignment(JLabel.RIGHT);
		mainPanel.add(label_preco);
		field_preco = new JTextField();
		mainPanel.add(field_preco);

		label_percentual = new JLabel("15%");
		label_percentual.setHorizontalAlignment(JLabel.RIGHT);
		mainPanel.add(label_percentual);
		field_percentual = new JSlider(0, 100, 15);
		field_percentual.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = field_percentual.getValue();
				label_percentual.setText(value+"%");
				frame.calculateTip();
			}
		});
		mainPanel.add(field_percentual);

		label_gorjeta = new JLabel("Gorjeta:");
		label_gorjeta.setHorizontalAlignment(JLabel.RIGHT);
		mainPanel.add(label_gorjeta);
		field_gorjeta = new JTextField();
		field_gorjeta.setDisabledTextColor(Color.RED);
		field_gorjeta.setEnabled(false);
		field_gorjeta.setVisible(false);
		mainPanel.add(field_gorjeta);

		label_total = new JLabel("Total:");
		label_total.setHorizontalAlignment(JLabel.RIGHT);
		mainPanel.add(label_total);
		field_total = new JTextField();
		field_total.setDisabledTextColor(Color.RED);
		field_total.setEnabled(false);
		field_total.setVisible(false);
		mainPanel.add(field_total);

		calculateBtn = new JButton("Calcular");
		calculateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.calculateTip();
			}
		});
		mainPanel.add(new JLabel());
		mainPanel.add(calculateBtn);
		
		rootPanel.add(mainPanel);
		this.add(rootPanel);
	}
	
	protected void calculateTip() {
		String conta = field_preco.getText();
		if (conta != null && conta != "") {
			try {
				double preco = Double.parseDouble(conta);
				int percent = field_percentual.getValue();
				double gorjeta = preco * Double.valueOf(percent)/100.0;
				double total = preco + gorjeta;
				field_gorjeta.setText(String.valueOf(gorjeta));
				field_gorjeta.setVisible(true);
				field_total.setText(String.valueOf(total));
				field_total.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
