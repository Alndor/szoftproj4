import java.util.ArrayList;

public class Commands {

	private Map cmap= new Map();
	
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
		
		
}
