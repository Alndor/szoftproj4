import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Commands {

	private Map cmap= new Map();
	
	File wd= new File(System.getProperty("user.dir"));//Working directory
	
	//listazo fuggvenyek a kulonbozo dolgokhoz
	public String listAkadaly() {
		int db=1;
		String stemp="\n";
		for(int i=0;i<cmap.GetMezo().size();i++) {
			Mezo temp=cmap.GetMezo().get(i);
			for (int j=0;j<temp.GetThings().size();j++) {
				Dolgok dtemp=temp.GetThings().get(j);
				if(dtemp.getName()=="Akadaly") {
					stemp+=(db+" "+temp.getPosition()+"\n");
				}
			}
		}
		if (stemp!="\n") System.out.println(stemp);
		return stemp;
		}
		
		
		public String listDolgozo() {
			int db=1;
			String stemp="\n";
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Dolgozo") {
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
	}
		
		public String listKapcsolo() {
			int db=1;
			String stemp="\n";
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Kapcsolo") {
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
		
	}
		
		
		public String listLada() {
			int db=1;
			String stemp="\n";
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Lada") {
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
	}
		
		
		public String listLyuk() {
			int db=1;
			String stemp="\n";
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Lyuk") {
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
		
	}
		
		
		public String listMez() {
			int db=1;
			String stemp= new String();
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Mez") {
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
	}
		
		
	
		
		public String listOlaj() {
			int db=1;
			String stemp= "\n";
				for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Olaj") {
						
						stemp+=(db+" "+temp.getPosition()+"\n");
					}
				}
			}
			if (stemp!="\n") System.out.println(stemp);
			return stemp;
	}
	
		//map betoltese
		public void loadMap(String s) {
			Map temp= new Map();
			//ide kene a beolvasas
			
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
			String inname="input" + t +".txt"; //t-edik input fÃ¡jl
			String outname="output" + t +".txt"; //t-edik output fÃ¡jl
			f_in=new File(wd,inname);
			f_out=new File(wd,outname);
			
			//Input beolvasÃ³
			FileReader rin = new FileReader(f_in);
			BufferedReader brin = new BufferedReader(rin);
			
			//Output beolvasÃ³
			FileReader rout = new FileReader(f_out);
			BufferedReader brout = new BufferedReader(rout);
			
			String comm;
			String out;
			String reqout="";
			String testout="";
			
			comm = brin.readLine();
			while (comm!=null){
				System.out.println(comm);
				//Itt lehet a Choosemap(comm) Ã©s hasonlÃ³ mÃ³don Ã¶sszefÅ±zni lehet fÅ±zni az outputokat, hogy Ã¶sszehasonlÃ­thatÃ³k legyenek
				comm = brin.readLine();
			}
			
			out = brout.readLine();
			while (out!=null){
				reqout += out+"\n";
				out = brout.readLine();
			}
			
			//Itt pedig Ã¶sszehasonlÃ­tÃ¡st
			System.out.println(reqout);
			
			brin.close();
			brout.close();
		}
		
		//Célmezõk kilistázásához használandó függvény
		
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
		
		
}
