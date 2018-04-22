import java.util.ArrayList;

public class Commands {

	private Map cmap= new Map();
	
	//listazo fuggvenyek a kulonbozo dolgokhoz
	public void listAkadaly() {
		int db=1;
		for(int i=0;i<cmap.GetMezo().size();i++) {
			Mezo temp=cmap.GetMezo().get(i);
			for (int j=0;j<temp.GetThings().size();j++) {
				Dolgok dtemp=temp.GetThings().get(j);
				if(dtemp.getName()=="Akadaly") {
					System.out.println(db+" "+temp.getPosition());
				}
			}
		}
		}
		
		
		public void listDolgozo() {
			int db=1;
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Dolgozo") {
						System.out.println(db+" "+temp.getPosition());
					}
				}
			}
		
	}
		
		public void listKapcsolo() {
			int db=1;
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Kapcsolo") {
						System.out.println(db+" "+temp.getPosition());
					}
				}
			}
		
	}
		
		
		public void listLada() {
			int db=1;
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Lada") {
						System.out.println(db+" "+temp.getPosition());
					}
				}
			}
		
	}
		
		
		public void listLyuk() {
			int db=1;
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Lyuk") {
						System.out.println(db+" "+temp.getPosition());
					}
				}
			}
		
	}
		
		
		public void listMez() {
			int db=1;
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Mez") {
						System.out.println(db+" "+temp.getPosition());
					}
				}
			}
		
	}
		
		
	
		
		public void listOlaj() {
			int db=1;
			for(int i=0;i<cmap.GetMezo().size();i++) {
				Mezo temp=cmap.GetMezo().get(i);
				for (int j=0;j<temp.GetThings().size();j++) {
					Dolgok dtemp=temp.GetThings().get(j);
					if(dtemp.getName()=="Olaj") {
						System.out.println(db+" "+temp.getPosition());
					}
				}
			}
		
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
