import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.io.File;

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



public class MyFrame extends JFrame{
	private JTable table = new JTable();		
	
	private Map map= new Map();
	
	public MyFrame(Map terkep){ //Jelenleg mindent a konstruktorban rak össze
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("GUI Demo");
		this.setResizable(false);
		JPanel p=new JPanel(new BorderLayout()); //A panel, amire rárakjuk majd a table-t
		map = terkep; //Betöltés, hogy a mapnak legyen tartalma
		table.setRowHeight(50); //Sorok magasságának beállítása az 50x50-es képek miatt
		table.setModel(map); //Átadjuk a mapet modelnek
		setColumnWidth(table); //Sajnos jobb megoldást nem tudok az oszlopok szélességének beállítására, így erre külön metódus van
		table.setDefaultRenderer(Object.class, new MyTableCellRenderer(table.getDefaultRenderer(Object.class))); //Saját renderer beállítása
		p.add(table, BorderLayout.CENTER); //A panelre rakjuk a table-t
		this.add(p); //Hozzáadjuk a frame-hez
		this.setVisible(true); //Megjelenítjuk
		this.pack(); //Pack-eljük, hogy az ablak akkora legyen, mint a table
	}
		
	//Az oszlopok méretezése
	public void setColumnWidth(JTable table){
		TableModel tm=table.getModel();
		TableColumnModel cmodel=table.getColumnModel();
		for (int i=0; i<tm.getColumnCount(); i++){
			cmodel.getColumn(i).setPreferredWidth(50);
		}
	}
	
	//A saját rendelelõ osztály megvalósítása
	class MyTableCellRenderer extends JLabel implements TableCellRenderer {

	   	 private TableCellRenderer renderer;

	   	 public MyTableCellRenderer(TableCellRenderer defRenderer) {
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
}
