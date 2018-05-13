import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.swing.JLabel;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;
//a mez�ket reprezent�l� oszt�ly
public class Mezo {
	GraphicMezo dr=new GraphicMezo();
	
	JLabel l= new JLabel();
	
	//a mez�n l�v� Dolgokat t�rolja
	private ArrayList<Dolgok> dolgok=new ArrayList<>();
	//megfelel� ir�nyokba be�ll�tott mez�ket t�rolja
	private HashMap<Iranyok, Mezo> szomszedok = new HashMap<Iranyok, Mezo>();
	//A mez� m�dos�t� �rt�ke
	private double mod=1;
	
	private Map mymap;
	
	//Dolgok mez�re helyez�se
	public void Accept(Dolgok d) {
		//System.out.println(">\t->[mezo].Accept(d)");
		dolgok.add(d);
		d.SetCurrent(this);
		
		
		//System.out.println("<\t<-[mezo].Accept(d)");
	}
	//Dolgok elt�vol�t�sa a mez�r�l
	public void Remove(Dolgok d) {
		//System.out.println(">\t->[mezo].Remove(d)");
		
		dolgok.remove(d);
		
		//System.out.println("<\t<-[mezo].Remove(d)");
	}
	
	//szomsz�dos mez� lek�r�se
	public Mezo GetNeighbor(Iranyok i) {
		//System.out.println(">\t->[mezo].GetNeighbour(i)");
		//System.out.println("<\t<-[mezo].GetNeighbour(i)");
		
		return szomszedok.get(i);
		
	}
	
	//szomsz�dos mez� be�ll�t�sa
	public void SetNeighbor(Iranyok i, Mezo m) {
		//System.out.println(">\t->[mezo].SetNeighbour(i, m)");
		
		szomszedok.put(i, m);
		
		//System.out.println("<\t<-[mezo].SetNeighbour(i, m)");
	}
	
	//Param�ter�l kapott Dolog �tk�ztet�se a mez�n l�v� dolgokkal
	public void GetDolgok(Dolgok d) {
		//System.out.println(">\t->[mezo].GetDolgok(d)");
		//System.out.println(dolgok.size());
		for (int i=dolgok.size();i>0;i--) {
			d.CollideWith(dolgok.get(i-1));
		}
		
		//System.out.println("<\t<-[mezo].GetDolgok(d)");
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
	
	public double GetMod(){
		return mod;
	}
	
	//"int mod" be�ll�t�sa
	
	public void SetMod(double m){
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
	public double CountWeight(Iranyok i) {
		int tmp = this.GetOsszSuly();
		
		//Ha nincs a k�vetkez� mez�n semmi, akkor le�ll a rekurzi�.
		if (this.GetNeighbor(i)!=null && this.GetNeighbor(i).GetOsszSuly() == 0) {
			return tmp*mod;
		}
		else if(this.GetNeighbor(i)!=null) {
			tmp += this.GetNeighbor(i).CountWeight(i);
			return tmp*mod;
		}		
		else return 0;
	}
	
	public String getPosition() {
		if(mymap == null)
			return "";
		return mymap.getCoord(this);
	}
	
	public JsonObject Save() {
		JsonArray things = SavedThings();
		
		JsonObject value = Json.createObjectBuilder()
				.add("modifier", String.valueOf(mod))
				.add("dolgok", things)
				.build();

		return (JsonObject)value;
	}
	
	private JsonArray SavedThings() {
		JsonArrayBuilder things = Json.createArrayBuilder();
		for(Dolgok dolog : dolgok) {
			things.add(dolog.Save());
		}
		return things.build();
	}
	
	public void setMap(Map mezok) {
		mymap = mezok;
	}
	
	public void Load(JsonObject ob, Map map) {
		
		mod = Double.parseDouble(ob.getString("modifier"));
		mymap = map;
		JsonArray things = ob.getJsonArray("dolgok");
		
		for(int i = 0; i < things.size(); ++i) {
			Dolgok dolog = setDolog(things.getJsonObject(i), map);
			if(dolog != null) {
				dolog.SetCurrent(this);
				dolgok.add(dolog);
			}
		}
	}
	
	private Dolgok setDolog(JsonObject ob, Map map) {
		Dolgok dolog;
		
		if(ob.getString("type").equals("akadaly")) {
			dolog = new Akadaly();
		}
		else if(ob.getString("type").equals("celmezo")) {
			dolog = new CelMezo();
		}
		else if(ob.getString("type").equals("dolgozo")) {
			dolog = new Dolgozo();
		}
		else if(ob.getString("type").equals("kapcsolo")) {
			dolog = new Kapcsolo();
		}
		else if(ob.getString("type").equals("lada")) {
			dolog = new Lada();
		}
		else if(ob.getString("type").equals("lyuk")) {
			dolog = new Lyuk();
		}
		else if(ob.getString("type").equals("mez")) {
			dolog = new Mez();
		}
		else if(ob.getString("type").equals("olaj")) {
			dolog = new Olaj();
		}
		else 
			return null;
			
		dolog.Load(ob, map);
		dolog.SetCurrent(this);
		return dolog;
	}
	
}
