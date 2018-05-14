import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
	
	private JPanel panel;	
	private JFrame f1;		
	private JComboBox c2;
	
	public Menu() {
		
		f1 = new JFrame("Menu");
		
		panel = new JPanel();
		
		JButton b1 = new JButton("Start game!");
		ActionListener al1 = new Jatekkezdes();
		b1.addActionListener(al1);
				
		
		JLabel l2 = new JLabel("Choose map:");
		
		//A palyakhoz hasznalt combobox.
		String[] z = {"EgyJatekos", "KetJatekos", "NegyJatekos"};
		
		c2 = new JComboBox(new DefaultComboBoxModel(z));
		
		GroupLayout layout = new GroupLayout(panel);
		
		panel.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(l2)
				.addComponent(c2)
		);
		
		layout.setVerticalGroup(
				   layout.createSequentialGroup()				      
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    		  .addComponent(l2)
				    		  .addComponent(c2))				      
		);	
		
		f1.add(panel, BorderLayout.CENTER);
		f1.add(b1, BorderLayout.SOUTH);
		f1.pack();
		Dimension dim = new Dimension();
		dim.width = 300;
		dim.height = 300;
		f1.setMinimumSize(dim);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class Jatekkezdes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Map map = new Map();
			
			if (c2.getSelectedItem().equals("EgyJatekos")) {
				map.Load("1PlayerMap.txt");
				map.setKjsz(1);
			}
			
			else if (c2.getSelectedItem().equals("KetJatekos")) {
				map.Load("2PlayerMap.txt");
				map.setKjsz(2);
			}
			
			else {
				map.Load("4PlayerMap.txt");
				map.setKjsz(4);
			}
			Game g = new Game();
			g.setMap(map);
			f1.dispose();
			MyFrame mf = new MyFrame(g);
		}
	}		
	
	public void NewGame() {
		
	}	
}
