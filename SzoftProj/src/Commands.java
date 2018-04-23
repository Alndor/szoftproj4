import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.HashMap;

public class Commands {

	private Map cmap= new Map();
	
	File wd= new File(System.getProperty("user.dir"));//Working directory
	
	//listazo fuggvenyek a kulonbozo dolgokhoz
	public String listAkadaly() {
		return listAny("Akadaly");
		}
		
		
		public String listDolgozo() {
			return listAny("Dolgozo");
	}
		
		public String listKapcsolo() {
			return listAny("Kapcsolo");
		
	}
		
		
		public String listLada() {
			return listAny("Lada");
	}
		
		
		public String listLyuk() {
			return listAny("Lyuk");
		
	}
		
		
		public String listMez() {
			return listAny("Mez");
	}
		
		
	
		
		public String listOlaj() {
			return listAny("Olaj");
	}
	
		//map betoltese
		public void loadMap(String s) {
			Map temp= new Map();
			temp.Load(s+".txt");
			
			cmap=temp;
			
		}
		//dolgozo mozgatasa az adott iranyba
		public void moveDolgozo(String s) {
			cmap.Running();
			Iranyok i=Iranyok.NOTHING;
			if(s=="w")	i=Iranyok.UP;
			if(s=="s") i=Iranyok.DOWN;
			if(s=="a") i=Iranyok.LEFT;
			if(s=="d") i=Iranyok.RIGHT;
			cmap.getCurrent().Move(i);
		}
		//mez lehelyezese
		public void placeMez() {
			cmap.Running();
			cmap.getCurrent().PlaceItem(cmap.getCurrent().GetItems().get(0));
		}
		//olaj lehelyezese
		public void placeOlaj() {
			cmap.Running();
			cmap.getCurrent().PlaceItem(cmap.getCurrent().GetItems().get(1));
		}
	
		public void ChooseTest(int t) throws IOException{
			File f_in=null;
			File f_out=null;
			String inname="input" + t +".txt"; //t-edik input f√°jl
			String outname="output" + t +".txt"; //t-edik output f√°jl
			f_in=new File(wd,inname);
			f_out=new File(wd,outname);
			
			//Input beolvas√≥
			FileReader rin = new FileReader(f_in);
			BufferedReader brin = new BufferedReader(rin);
			
			//Output beolvas√≥
			FileReader rout = new FileReader(f_out);
			BufferedReader brout = new BufferedReader(rout);
			
			String comm;
			String out;
			String reqout="";
			String testout="";
			
			comm = brin.readLine();
			while (comm!=null){
				System.out.println(comm);
				//Itt lehet a Choosemap(comm) √©s hasonl√≥ m√≥don √∂sszef≈±zni lehet f≈±zni az outputokat, hogy √∂sszehasonl√≠that√≥k legyenek
				comm = brin.readLine();
			}
			
			out = brout.readLine();
			while (out!=null){
				reqout += out+"\n";
				out = brout.readLine();
			}
			
			//Itt pedig √∂sszehasonl√≠t√°st
			System.out.println(reqout);
			
			brin.close();
			brout.close();
		}
		
		//CÈlmezık kilist·z·s·hoz haszn·landÛ f¸ggvÈny
		
		public String ListCelmezo() {
			int db=1;
			String stemp="\n";
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="CelMezo") {
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
		}
		
		public void EndGame() {
			System.exit(0);
		}
		
		public void GiveUp(int sz) {
			cmap.getInGame().get(0).GiveUp();			
		}
		
		public void CompareTest(String uj, int elvart) throws IOException {
			File f_out=null;
			
			String outname="output" + elvart +".txt";
			
			f_out = new File(wd, outname);
			
			FileReader rout = new FileReader(f_out);
			BufferedReader brout = new BufferedReader(rout);
			
			String out;
			String reqout="";
			
			out = brout.readLine();
			while (out!=null) {
				reqout += out+"\n";
				out = brout.readLine();
			}
			
			if (uj.equals(reqout)) {
				System.out.println("\n\nAz eredmÈny egyezik az elv·rttal.\n\n");
			}
			else {
				System.out.println("\n\nAz eredmÈny nem egyezik az elv·rttal.\n\n");
			}
			
			brout.close();
		}
		
		public void FajlBolParancs(String fajlnev) throws IOException {
			File f_out=null;					
			
			f_out = new File(wd, fajlnev);
			
			FileReader rout = new FileReader(f_out);
			BufferedReader brout = new BufferedReader(rout);
			
			String out;
			String reqout = "";
			
			out = brout.readLine();
			while (out!=null) {
				
				if (out.equals("loadMap Test1")) {
					this.loadMap("Test1");
				}
				
				if (out.equals("loadMap Test2")) {
					this.loadMap("Test2");
				}
				
				if (out.equals("loadMap Test3")) {
					this.loadMap("Test3");
				}
				
				if (out.equals("loadMap Test4")) {
					this.loadMap("Test4");
				}
				
				if (out.equals("loadMap Test5")) {
					this.loadMap("Test5");
				}
				
				if (out.equals("loadMap Test6")) {
					this.loadMap("Test6");
				}
				
				if (out.equals("listDolgozo")) {
					String reqout7 = this.listDolgozo();
					reqout += reqout7;
				}
				
				if (out.equals("listLada")) {
					String reqout6 = this.listLada();
					reqout += reqout6;
				}
				
				if (out.equals("listCelmezo")) {
					String reqout5 = this.ListCelmezo();
					reqout += reqout5;
				}
				
				if (out.equals("listLyuk")) {
					String reqout4 = this.listLyuk();
					reqout += reqout4;
				}
				
				if (out.equals("listAkadaly")) {
					String reqout3 = this.listAkadaly();
					reqout += reqout3;
				}
				
				if (out.equals("listMez")) {
					String reqout2 = this.listMez();
					reqout += reqout2;
				}
				
				if (out.equals("listOlaj")) {
					String reqout1 = this.listOlaj();
					reqout += reqout1;
				}
				
				if (out.equals("PlaceDolgozoMez")) {
					this.placeMez();
				}
				
				if (out.equals("PlaceDolgozoOlaj")) {
					this.placeOlaj();
				}
				
				if (out.equals("GiveUp 1")) {
					this.GiveUp(1);
				}
				
				if (out.equals("EndGame")) {
					this.EndGame();
				}
				
				if (out.equals("moveDolgozo Right")) {
					this.moveDolgozo("d");
				}
						
				if (out.equals("moveDolgozo Left")) {
					this.moveDolgozo("a");
				}
				
				if (out.equals("moveDolgozo Up")) {
					this.moveDolgozo("w");
				}
				
				if (out.equals("moveDolgozo Down")) {
					this.moveDolgozo("s");
				}
				
				out = brout.readLine();
			}
			
			brout.close();				
		}		
		
		
		
		
		
		public String listAny(String s) {
			int db=1;
			String stemp="\n";
			TreeMap<Coord, Mezo> tmpmap = cmap.GetMezo();
			
			for(Entry<Coord, Mezo> tmp : tmpmap.entrySet()){
				Mezo temp = tmp.getValue();
				ArrayList<Dolgok> things = temp.GetThings();
				
				if(things != null) {
					for (int j = 0;j < things.size(); j++) {
						if(things.get(j).getName() != null)
						if(things.get(j).getName().equals(s)) {
							stemp+=(db+" "+temp.getPosition()+"\n");
						}
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
			}
		
		
		
		
}
