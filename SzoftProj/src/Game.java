import java.util.ArrayList;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	
	
	//elind�tja a j�t�kot
	public void StartGame() {
		System.out.println(">\t->[game].StartGame()");
			
		System.out.println("<\t<-[game].StartGame()");
	}
	
	//v�get vet a j�t�knak
	public void EndGame() {
		System.out.println(">\t->[game].EndGame()");
	 
		
		System.out.println("<\t<-[game].EndGame()");
	}
	
	
	//a j�t�k felad�s�ra szolg�l
	public void Concede() {
		System.out.println(">\t->[game].EndGame()");
		
		EndGame();
		
		System.out.println("<\t<-[game].EndGame()");
	}
	
	
	//kiv�laszthatjuk a p�ly�t
	public void ChooseMap() {
		System.out.println(">\t->[game].ChooseMap()");
		
		//Gondolom itt tolti fel a mapot
		
		System.out.println("<\t<-[game].ChooseMap()");
	}
	
	//"ArrayList maps" lek�rdez�se
	
	public ArrayList<Map> GetMaps() {
		return maps;
	}
	
	//"ArrayList maps" be�ll�t�sa
	
	public void SetMaps(ArrayList<Map> tmp) {
		maps = tmp;
	}
}
