import java.util.ArrayList;
import java.util.HashMap;
//a mez�ket reprezent�l� oszt�ly
public class Mezo {
	//a mez�n l�v� Dolgokat t�rolja
	private ArrayList<Dolgok> dolgok=new ArrayList<>();
	//megfelel� ir�nyokba be�ll�tott mez�ket t�rolja
	private HashMap<Iranyok, Mezo> szomszedok = new HashMap<>();
	//A mez� m�dos�t� �rt�ke
	private int mod;
	
	//Dolgok mez�re helyez�se
	public void Accept(Dolgok d) {
		System.out.println(">\t->[mezo].Accept(d)");
		
		dolgok.add(d);
		d.SetCurrent(this);
		
		
		System.out.println("<\t<-[mezo].Accept(d)");
	}
	//Dolgok elt�vol�t�sa a mez�r�l
	public void Remove(Dolgok d) {
		System.out.println(">\t->[mezo].Remove(d)");
		
		dolgok.remove(d);
		
		System.out.println("<\t<-[mezo].Remove(d)");
	}
	
	//szomsz�dos mez� lek�r�se
	public Mezo GetNeighbor(Iranyok i) {
		System.out.println(">\t->[mezo].GetNeighbour(i)");
		System.out.println("<\t<-[mezo].GetNeighbour(i)");
		
		return szomszedok.get(i);
		
	}
	
	//szomsz�dos mez� be�ll�t�sa
	public void SetNeighbor(Iranyok i, Mezo m) {
		System.out.println(">\t->[mezo].SetNeighbour(i, m)");
		
		szomszedok.put(i, m);
		
		System.out.println("<\t<-[mezo].SetNeighbour(i, m)");
	}
	
	//Param�ter�l kapott Dolog �tk�ztet�se a mez�n l�v� dolgokkal
	public void GetDolgok(Dolgok d) {
		System.out.println(">\t->[mezo].GetDolgok(d)");
		//System.out.println(dolgok.size());
		for (int i=dolgok.size();i>0;i--) {
			d.CollideWith(dolgok.get(i-1));
		}
		
		System.out.println("<\t<-[mezo].GetDolgok(d)");
	}
	
	//"ArrayList dolgok" lek�rdez�se
	
	public ArrayList<Dolgok> GetThings() {
		return dolgok;
	}
	
	//"ArrayList dolgok" be�ll�t�sa
	
	public void SetThings(ArrayList<Dolgok> seged) {
		dolgok = seged;
	}
	
	//"HashMap szomszedok" lek�rdez�se
	
	public HashMap<Iranyok, Mezo> GetSzomszed() {
		return szomszedok;
	}
	
	//"HashMap szomszedok" be�ll�t�sa
	
	public void SetSzomszed(HashMap<Iranyok, Mezo> tmp) {
		szomszedok = tmp;
	}
	
	//"int mod" lek�rdez�se
	
	public int GetMod(){
		return mod;
	}
	
	//"int mod" be�ll�t�sa
	
	public void SetMod(int m){
		mod = m;
	}
	
	//A mez�n l�v� �sszes dolognak az egy�ttes s�lya.
	public int GetOsszSuly() {		
		int cntr = 0;
		for (int i = 0; i < dolgok.size(); i++) {
			cntr += dolgok.get(i).GetWeight();
		}
		return cntr;
	}
	
	//Egy adott ir�nyban l�v� �sszes doboz s�lya (m�dos�t�sokkal egy�tt)
	public int CountWeight(Iranyok i) {
		int tmp = this.GetOsszSuly();
		
		//Ha nincs a k�vetkez� mez�n semmi, akkor le�ll a rekurzi�.
		if (this.GetNeighbor(i).GetOsszSuly() == 0) {
			return tmp*mod;
		}
		else {
			tmp += this.GetNeighbor(i).CountWeight(i);
			return tmp*mod;
		}
	}
}
