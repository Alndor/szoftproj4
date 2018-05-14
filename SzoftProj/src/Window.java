import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import sun.swing.table.DefaultTableCellHeaderRenderer;


public class Window extends JFrame {
	private Game game=new Game();
	
	private Menu menu;
	
	private JTable jt= new JTable();
	
	public void SetGame(Map m) {
		game.setMap(m);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tologatos Biszimbaszom");
		setResizable(false);
		JPanel p=new JPanel(new BorderLayout()); 
		jt.setRowHeight(50); 
		jt.setModel(m);
		setColumnWidth(jt); 
		jt.addKeyListener(game.c.keh);
		jt.setDefaultRenderer(Object.class,new MyWindowCellRenderer(jt.getDefaultRenderer(Object.class)));
		
		p.add(jt, BorderLayout.CENTER);
		this.add(p);
		this.setVisible(true);
		this.pack();
		
		
		RunGame();
	}
	
	public void setColumnWidth(JTable table){
		TableModel tm=table.getModel();
		TableColumnModel cmodel=table.getColumnModel();
		for (int i=0; i<tm.getColumnCount(); i++){
			cmodel.getColumn(i).setPreferredWidth(50);
		}
	}
	
	
	
	class MyWindowCellRenderer extends JLabel implements TableCellRenderer {

	   	 private TableCellRenderer renderer;

	   	 public MyWindowCellRenderer(TableCellRenderer defRenderer) {
	   		 this.renderer = defRenderer;
	   	 }
	   	 
	   	 //Maga a renderer
	   	 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	   		 //A régi házi feladatomnál a COmponent-et változtattam, de azzal nem lehet szöveget és képet váltosztatni, így egy JLabel-t ad majd vissza
	   		 JComponent component = (JComponent)renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	   		 JLabel cellLabel = new JLabel(); //Ezt változtatja majd a modell szerint
	   		 ImageIcon image;
	   		 String s = (String)value; //A map által elküldött a mezõn lévõ dolgok listája
	   		 String things[] = s.split(" ");
	   		 Border b = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
	   		 
	   		 //Sima foreach-el nézi végig, ez majd még fejleszthetõ
	   		 for (String str : things){
	   			 switch (str){
	   			 case "Mez":
	   				 b = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.orange);
	   				 break;
	   			 case "Olaj":
	   				 b = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black);
	   				 break;
	   			 case "Akadaly":
	   				 image=new ImageIcon("Akadaly.gif");
	   				 cellLabel.setIcon(image);
	   				 //cellLabel.setText("A");
	   				 break;
	   			case "Lada":
	   				image=new ImageIcon("Lada.gif");
	   				 cellLabel.setIcon(image);
	   				 //cellLabel.setText("L");
	   				 break;
	   			case "Dolgozo":
	   				image=new ImageIcon("Dolgozo.gif");
	   				 cellLabel.setIcon(image);
	   				 //cellLabel.setText("D");
	   				 break;
	   			case "Lyuk":
	   				image=new ImageIcon("Lyuk.gif");
	   				 cellLabel.setIcon(image);
	   				 //cellLabel.setText("Ly");
	   				 break;
	   			case "Kapcsolo":
	   				image=new ImageIcon("Kapcsolo.gif");
	   				 cellLabel.setIcon(image);
	   				 //cellLabel.setText("K");
	   				 break;
	   			case "CelMezo":
	   				image=new ImageIcon("CelMezo.gif");
	   				 cellLabel.setIcon(image);
	   				 //cellLabel.setText("C");
	   				 break;
	   		  default: 
                 image=new ImageIcon("Mezo.gif"); 
                 cellLabel.setIcon(image); 
                 //cellLabel.setText("A"); 
                 break; 
	   			 }
	   		 }
	   		//((DefaultTableCellRenderer)component).setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	   		//component.setFont(component.getFont().deriveFont(Font.BOLD));
	   		//component.setBorder(b);
	   		cellLabel.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	   		cellLabel.setBorder(b);
	   		cellLabel.setBackground(Color.blue);
	   		// return component;
	   		return cellLabel;
	   	 }
	   	
	}
	
	
	
	public void RunGame() {
		while(game.getMap().getInGame().size()!=0) {
			game.getMap().Running();
			
			
			
			
			
		}
		
		game.EndGame();
	}
}
