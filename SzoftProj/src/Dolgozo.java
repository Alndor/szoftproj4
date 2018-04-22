import java.util.ArrayList;

//a játékosok által irányított dolgozók osztálya
public class Dolgozo extends Dolgok {
	//az adott játékos pontjait tároló változó
	private int points;
	private Iranyok irany = null;
	//változó, ami számon tartja, hogy sikerült-e a mozgatás
	protected boolean refused = false;
	//a megfelelõ kommunikáláshoz használt változók
	private Map m = new Map();
	private Game g = new Game();
	//A dolgozó letehetõ Itemjeinek gyüjteménye
	private ArrayList<Item> items = new ArrayList<>();
	
	//a paraméterül kapott Dologhoz hozzáüti a dolgozót
	@Override
	public void CollideWith(Dolgok d) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[dolgozo].CollideWith(d)");
		
		d.HitByDolgozo(this, irany);
		
		System.out.println("<\t<-[dolgozo].CollideWith(d)");
	}

	//a paraméterül kapott dolgozót egy megfelelõ irányba üti
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[dolgozo].HitByDolgozo(d, i)");
		//dolgozó nem léphet dolgozóra
		d.Refuse();
		System.out.println("<\t<-[dolgozo].HitByDolgozo(d, i)");
	}

	//a paraméterül kapott láda egy megfelelõ irányba üti
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[dolgozo].HitByLada(l, i)");
		
		irany = i;
		Mezo nextMezo = current.GetNeighbor(i);
		nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a dolgozót nem lehet a következõ mezõre tolni, meghal
			m.Kill();
			return;
		}
		else
			nextMezo.Accept(this);
		
		
		System.out.println("<\t<-[dolgozo].HitByLada(l, i)");
	}
	
	
	//a játékos mozgatja a dolgozót egy irányba, vagy dönthet úgy is, hogy nem mozdul a körben
	public void Move(Iranyok i) {
		System.out.println(">\t->[dolgozo].Move(i)");
		if(i.getDir()!='x') {
				Mezo nextMezo = current.GetNeighbor(i);
				nextMezo.GetDolgok(this);
				current.Remove(this);
				
				//amennyiben a dolgozó nem léphet a következõ mezõre az aktuális mezõn marad
				if(refused) {
					current.Accept(this);
					refused=false;
				}		
				else
					nextMezo.Accept(this);	
		}
		else current.Accept(this);
		
		
		System.out.println("<\t<-[dolgozo].Move(i)");
	}
	
	
	//növeli a dolgozó pontjainak számát egyel, ha sikeresen a helyére tolt egy ládát, akkor hívódik meg
	public void PointsGiven(){
		System.out.println(">\t->[dolgozo].PointsGiven()");
		
		points++;		
		
		System.out.println("<\t<-[dolgozo].PointsGiven()");
	}
	
	//a játékos feladhatja a játékot, ha úgy érzi, hogy már nem vezet sehova
	public void GiveUp() {
		System.out.println(">\t->[dolgozo].GiveUp()");
		
		g.Concede();
		
		System.out.println("<\t<-[dolgozo].GiveUp()");
	}
	
	
	//amennyiben dolgozó lépne dolgozóra ez a függvény hívódik meg, ami nem engedi a lépést
	public void Refuse() {
		System.out.println(">\t->[dolgozo].Refuse()");
		
		refused = true;
		
		System.out.println("<\t<-[dolgozo].Refuse()");
	}
	
	//Item lerakása
	public void PlaceItem(Item it){
		current.Accept(it);
	}
	
	//"int points" lekérdezése
	
	public int GetPoints() {
		return points;
	}
	
	//"int points" beállítása
	
	public void SetPoints(int tmp) {
		points = tmp;
	}
	
	//"Iranyok irany" lekérdezése
	
	public Iranyok GetIrany() {
		return irany;
	}
	
	//"Iranyok irany" beállítása
	
	public void SetIrany(Iranyok tmp) {
		irany = tmp;
	}
	
	//"Map m" lekérdezése
	
	public Map GetMap() {
		return m;
	}
		
	//"Map m" beállítása
		
	public void SetMap(Map tmp) {
		m = tmp;
	}
	
	//"Game g" lekérdezése
	
	public Game GetGame() {
		return g;
	}
		
	//"Game g" beállítása
		
	public void SetGame(Game tmp) {
		g = tmp;
	}
	
	//"ArrayList items" lekérdezése
	
	public ArrayList<Item> GetItems(){
		return items;
	}
	
	//"ArrayList items" beaállytása
	
	public void SetItems(ArrayList<Item> tmp){
		items = tmp;
	}
}
