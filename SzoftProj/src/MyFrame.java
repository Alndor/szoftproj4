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
	
	public MyFrame(Game g){ //Jelenleg mindent a konstruktorban rak �ssze
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("GUI Demo");
		this.setResizable(false);
		JPanel p=new JPanel(new BorderLayout()); //A panel, amire r�rakjuk majd a table-t
		p.addKeyListener(g.getController().getKeh());
		p.setFocusable(true);
		p.requestFocusInWindow();
		map = g.getMap(); //Bet�lt�s, hogy a mapnak legyen tartalma
		table.setRowHeight(50); //Sorok magass�g�nak be�ll�t�sa az 50x50-es k�pek miatt
		table.setModel(map); //�tadjuk a mapet modelnek
		setColumnWidth(table); //Sajnos jobb megold�st nem tudok az oszlopok sz�less�g�nek be�ll�t�s�ra, �gy erre k�l�n met�dus van
		table.setDefaultRenderer(Object.class, new MyTableCellRenderer(table.getDefaultRenderer(Object.class))); //Saj�t renderer be�ll�t�sa
		p.add(table, BorderLayout.CENTER); //A panelre rakjuk a table-t
		this.add(p); //Hozz�adjuk a frame-hez
		this.setVisible(true); //Megjelen�tjuk
		this.pack(); //Pack-elj�k, hogy az ablak akkora legyen, mint a table
	}
		
	//Az oszlopok m�retez�se
	public void setColumnWidth(JTable table){
		TableModel tm=table.getModel();
		TableColumnModel cmodel=table.getColumnModel();
		for (int i=0; i<tm.getColumnCount(); i++){
			cmodel.getColumn(i).setPreferredWidth(50);
		}
	}
	
	public void Exit() {
		this.dispose();
	}
	
	//A saj�t rendelel� oszt�ly megval�s�t�sa
	class MyTableCellRenderer extends JLabel implements TableCellRenderer {

	   	 private TableCellRenderer renderer;

	   	 public MyTableCellRenderer(TableCellRenderer defRenderer) {
	   		 this.renderer = defRenderer;
	   	 }
	   	 
	   	 //Maga a renderer
	   	 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	   		 //A r�gi h�zi feladatomn�l a COmponent-et v�ltoztattam, de azzal nem lehet sz�veget �s k�pet v�ltosztatni, �gy egy JLabel-t ad majd vissza
	   		 JComponent component = (JComponent)renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	   		 JLabel cellLabel = new JLabel(); //Ezt v�ltoztatja majd a modell szerint
	   		 ImageIcon image;
	   		 String s = (String)value; //A map �ltal elk�ld�tt a mez�n l�v� dolgok list�ja
	   		 String things[] = s.split(" ");
	   		 Border b = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
	   		 
	   		image=new ImageIcon("Mezo.gif");
	   		cellLabel.setIcon(image);
	   		 
	   		 //Sima foreach-el n�zi v�gig, ez majd m�g fejleszthet�
	   		 for (String str : things){
	   			 switch (str){	   			 
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
	   			case "Mez":
	   				 b = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.orange);	   				
	   				 break;
	   			 case "Olaj":
	   				 b = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black);	   				 
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
