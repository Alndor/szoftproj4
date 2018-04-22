import java.util.ArrayList;
import java.util.HashMap;
//a mezõket reprezentáló osztály
public class Mezo {
	//a mezõn lévõ Dolgokat tárolja
	private ArrayList<Dolgok> dolgok=new ArrayList<>();
	//megfelelõ irányokba beállított mezõket tárolja
	private HashMap<Iranyok, Mezo> szomszedok = new HashMap<>();
	//A mezõ módosító értéke
	private int mod;
	
	//Dolgok mezõre helyezése
	public void Accept(Dolgok d) {
		System.out.println(">\t->[mezo].Accept(d)");
		
		dolgok.add(d);
		d.SetCurrent(this);
		
		
		System.out.println("<\t<-[mezo].Accept(d)");
	}
	//Dolgok eltávolítása a mezõrõl
	public void Remove(Dolgok d) {
		System.out.println(">\t->[mezo].Remove(d)");
		
		dolgok.remove(d);
		
		System.out.println("<\t<-[mezo].Remove(d)");
	}
	
	//szomszédos mezõ lekérése
	public Mezo GetNeighbor(Iranyok i) {
		System.out.println(">\t->[mezo].GetNeighbour(i)");
		System.out.println("<\t<-[mezo].GetNeighbour(i)");
		
		return szomszedok.get(i);
		
	}
	
	//szomszédos mezõ beállítása
	public void SetNeighbor(Iranyok i, Mezo m) {
		System.out.println(">\t->[mezo].SetNeighbour(i, m)");
		
		szomszedok.put(i, m);
		
		System.out.println("<\t<-[mezo].SetNeighbour(i, m)");
	}
	
	//Paraméterül kapott Dolog ütköztetése a mezõn lévõ dolgokkal
	public void GetDolgok(Dolgok d) {
		System.out.println(">\t->[mezo].GetDolgok(d)");
		//System.out.println(dolgok.size());
		for (int i=dolgok.size();i>0;i--) {
			d.CollideWith(dolgok.get(i-1));
		}
		
		System.out.println("<\t<-[mezo].GetDolgok(d)");
	}
	
	//"ArrayList dolgok" lekérdezése
	
	public ArrayList<Dolgok> GetThings() {
		return dolgok;
	}
	
	//"ArrayList dolgok" beállítása
	
	public void SetThings(ArrayList<Dolgok> seged) {
		dolgok = seged;
	}
	
	//"HashMap szomszedok" lekérdezése
	
	public HashMap<Iranyok, Mezo> GetSzomszed() {
		return szomszedok;
	}
	
	//"HashMap szomszedok" beállítása
	
	public void SetSzomszed(HashMap<Iranyok, Mezo> tmp) {
		szomszedok = tmp;
	}
	
	//"int mod" lekérdezése
	
	public int GetMod(){
		return mod;
	}
	
	//"int mod" beállítása
	
	public void SetMod(int m){
		mod = m;
	}
	
	//A mezõn lévõ összes dolognak az együttes súlya.
	public int GetOsszSuly() {		
		int cntr = 0;
		for (int i = 0; i < dolgok.size(); i++) {
			cntr += dolgok.get(i).GetWeight();
		}
		return cntr;
	}
	
	//Egy adott irányban lévõ összes doboz súlya (módosításokkal együtt)
	public int CountWeight(Iranyok i) {
		int tmp = this.GetOsszSuly();
		
		//Ha nincs a következõ mezõn semmi, akkor leáll a rekurzió.
		if (this.GetNeighbor(i).GetOsszSuly() == 0) {
			return tmp*mod;
		}
		else {
			tmp += this.GetNeighbor(i).CountWeight(i);
			return tmp*mod;
		}
	}
}
