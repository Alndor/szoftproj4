import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
	private JPanel panel;
	
	public Menu() {
		panel = new JPanel();
		
		JButton b1 = new JButton("Start game!");
		ActionListener al1 = new Jatekkezdes();
		b1.addActionListener(al1);
		
		//A jatekosok szamat beallito combobox.
		Integer[] x = new Integer[20];		
		int i;
		for (i = 0; i < 20; i++) {
			x[i] = i+1;
		}
		
		JComboBox c1 = new JComboBox(new DefaultComboBoxModel(x));
		
		JLabel l1 = new JLabel("Number of players:");
		
		JLabel l2 = new JLabel("Choose map:");
		
		//A palyakhoz hasznalt combobox.
		String[] z = {"Atlagos", "Nehez", "Special"};
		
		JComboBox c2 = new JComboBox(new DefaultComboBoxModel(z));
		
		GroupLayout layout = new GroupLayout(panel);
		
		panel.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(l1)
						.addComponent(l2)
						.addComponent(b1))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(c1)
						.addComponent(c2))						
		);
		
		layout.setVerticalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    		  .addComponent(l1)
				    		  .addComponent(c1))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    		  .addComponent(l2)
				    		  .addComponent(c2))
				      .addComponent(b1)
		);						
	}
	
	public class Jatekkezdes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
						
		}
	}
	
	public void Exit() {
		
	}
	
	public void NewGame() {
		
	}
}
