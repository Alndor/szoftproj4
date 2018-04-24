import java.io.IOException;
import java.util.Scanner;

public class Main3Function {
	
	public static void main(String args[]) throws IOException {
								
		Commands comm = new Commands();
		
		//Alapmenü, amibõl választhat a felhasználó.
		
		System.out.println("1 Lépés lyukra");
		System.out.println("2 Lépés falra");
		System.out.println("3 Lépés dolgozóra");
		System.out.println("4 Lépés kapcsolóra");
		System.out.println("5 Lépés ládára");
		System.out.println("6 Lépés célmezõre");
		System.out.println("7 Tolható láda tolása");
		System.out.println("8 Nem tolható láda tolása");
		System.out.println("9 Láda lyukra tolása");
		System.out.println("10 Láda kapcsolóra tolása");
		System.out.println("11 Láda célmezõre tolása");
		System.out.println("12 Láda falhoz tolása");
		System.out.println("13 Tolható láda lánc tolása");
		System.out.println("14 Nem tolható láda lánc tolása");		
		System.out.println("15 Láda-dolgozó lánc tolása");
		System.out.println("16 Láda-dolgozó-fal lánc tolása");
		System.out.println("17 Ládák tolása mézzel");
		System.out.println("18 Ládák tolása olajjal");
		System.out.println("19 Láda-láda-célmezõ tolása");
		System.out.println("20 Feladás");
		System.out.println("21 Kilépés");
		System.out.println("22 Méz lerakása");
		System.out.println("23 Olaj lerakása");
//		System.out.println("24 Fájlból parancs olvasása");
		System.out.println("\nÍrja be a választott teszteset számát!");
		
		Scanner scanner = new Scanner(System.in);		
		int szam = scanner.nextInt();		
		scanner.close();
		
		switch (szam) {
		case 1:
				comm.loadMap("Test1");
				String a1 = comm.listDolgozo();
				String a2 = comm.listLyuk();
				comm.moveDolgozo("d");
				String a3 = comm.listDolgozo();
				String a4 = a1 + a2 + a3;
				comm.CompareTest(a4, 1);
				break;
		case 2:
				comm.loadMap("Test1");
				String a11 = comm.listAkadaly();
				String a22 = comm.listDolgozo();
				comm.moveDolgozo("w");
				String a33 = comm.listDolgozo();
				String a44 = a11 + a22 + a33;
				comm.CompareTest(a44, 2);
				break;
		case 3:
				comm.loadMap("Test1");
				String a01 = comm.listDolgozo();
				comm.moveDolgozo("a");
				String a02 = comm.listDolgozo();
				String a03 = a01 + a02;
				comm.CompareTest(a03, 3);
				break;
		case 4:
				comm.loadMap("Test1");
				String a20 = comm.listDolgozo();
				String a21 = comm.listKapcsolo();
				String a23 = comm.listLyuk();
				comm.moveDolgozo("s");
				String a24 = comm.listDolgozo();
				String a25 = comm.listLyuk();
				String a26 = a20 + a21 + a23 + a24 + a25;
				comm.CompareTest(a26, 4);
				break;
		case 5:
				comm.loadMap("Test2");
				String a27 = comm.listDolgozo();
				String a28 = comm.listLada();
				comm.moveDolgozo("d");
				String a29 = comm.listDolgozo();
				String a30 = comm.listLada();
				String a31 = a27 + a28 + a29 + a30;
				comm.CompareTest(a31, 5);
				break;
		case 6:
				comm.loadMap("Test2");
				String a32 = comm.listDolgozo();
				String a34 = comm.ListCelmezo();
				comm.moveDolgozo("w");
				String a35 = comm.listDolgozo();
				String a36 = comm.ListCelmezo();
				String a37 = a32 + a34 + a35 + a36;
				comm.CompareTest(a37, 6);
				break;
		case 7:
				comm.loadMap("Test2");
				String a38 = comm.listDolgozo();
				String a39 = comm.listLada();
				comm.moveDolgozo("a");
				String a40 = comm.listDolgozo();
				String a41 = comm.listLada();
				String a42 = a38 + a39 + a40 + a41;
				comm.CompareTest(a42, 7);
				break;
		case 8:
				comm.loadMap("Test2");
				String a43 = comm.listDolgozo();
				String a45 = comm.listLada();
				comm.moveDolgozo("s");
				String a46 = comm.listDolgozo();
				String a47 = comm.listLada();
				String a48 = a43 + a45 + a46 + a47;
				comm.CompareTest(a48, 8);
				break;
		case 9:
				comm.loadMap("Test3");
				String a49 = comm.listDolgozo();
				String a50 = comm.listLada();
				comm.moveDolgozo("d");
				String a51 = comm.listDolgozo();
				String a52 = comm.listLada();
				String a53 = a49 + a50 + a51 + a52;
				comm.CompareTest(a53, 9);
				break;
		case 10:
				comm.loadMap("Test3");
				String a54 = comm.listDolgozo();
				String a55 = comm.listLada();
				String a56 = comm.listLyuk();
				comm.moveDolgozo("a");
				String a57 = comm.listDolgozo();
				String a58 = comm.listLada();
				String a59 = comm.listLyuk();
				String a60 = a54 + a55 + a56 + a57 + a58 + a59;
				comm.CompareTest(a60, 10);
				break;
		case 11:
				comm.loadMap("Test3");
				String a61 = comm.listDolgozo();
				String a62 = comm.listLada();
				String a63 = comm.ListCelmezo();
				String a64 = comm.listAkadaly();
				comm.moveDolgozo("s");
				String a65 = comm.listDolgozo();
				String a66 = comm.listLada();
				String a67 = comm.ListCelmezo();
				String a68 = comm.listAkadaly();
				String a69 = a61 + a62 + a63 + a64 + a65 + a66 + a67 + a68;
				comm.CompareTest(a69, 11);
				break;
		case 12:
				comm.loadMap("Test3");
				String a70 = comm.listDolgozo();
				String a71 = comm.listLada();				
				String a72 = comm.listAkadaly();
				comm.moveDolgozo("w");
				String a73 = comm.listDolgozo();
				String a74 = comm.listLada();				
				String a75 = comm.listAkadaly();
				String a76 = a70 + a71 + a72 + a73 + a74 + a75;
				comm.CompareTest(a76, 12);
				break;
		case 13:
				comm.loadMap("Test4");
				String a77 = comm.listDolgozo();
				String a78 = comm.listLada();
				comm.moveDolgozo("d");
				String a79 = comm.listDolgozo();
				String a80 = comm.listLada();
				String a81 = a77 + a78 + a79 + a80;
				comm.CompareTest(a81, 13);
				break;
		case 14:
				comm.loadMap("Test4");
				String a82 = comm.listDolgozo();
				String a83 = comm.listLada();
				comm.moveDolgozo("a");
				String a84 = comm.listDolgozo();
				String a85 = comm.listLada();
				String a86 = a82 + a83 + a84 + a85;
				comm.CompareTest(a86, 14);
				break;
		case 15:
				comm.loadMap("Test4");
				String a87 = comm.listDolgozo();
				String a88 = comm.listLada();
				comm.moveDolgozo("s");
				String a89 = comm.listDolgozo();
				String a90 = comm.listLada();
				String a91 = a87 + a88 + a89 + a90;
				comm.CompareTest(a91, 15);
				break;
		case 16:
				comm.loadMap("Test4");
				String a92 = comm.listDolgozo();
				String a93 = comm.listLada();
				String a94 = comm.listAkadaly();
				comm.moveDolgozo("s");
				comm.moveDolgozo("s");
				String a95 = comm.listDolgozo();
				String a96 = comm.listLada();
				String a97 =  a92 + a93 + a94 + a95 + a96;
				comm.CompareTest(a97, 16);
				break;
		case 17:
				comm.loadMap("Test5");
				String a98 = comm.listMez();				
				String a99 = comm.listLada();	
				String a100 = comm.listDolgozo();
				comm.moveDolgozo("a");							
				String a101 = comm.listLada();
				String a102 = comm.listMez();
				String a103 = comm.listDolgozo();
				String a104 = a98 + a99 + a100 + a101 + a102 + a103;
				comm.CompareTest(a104, 17);
				break;
		case 18:
				comm.loadMap("Test5");
				String a105 = comm.listOlaj();	
				String a106 = comm.listDolgozo();
				String a107 = comm.listLada();					
				comm.moveDolgozo("s");											
				String a108 = comm.listOlaj();
				String a109 = comm.listDolgozo();
				String a110 = comm.listLada();
				String a111 = a105 + a106 + a107 + a108 + a109+a110;
				comm.CompareTest(a111, 18);
				break;
		case 19:
				comm.loadMap("Test6");				
				String a112 = comm.listDolgozo();
				String a113 = comm.ListCelmezo();
				String a114 = comm.listAkadaly();
				String a115 = comm.listLada();					
				comm.moveDolgozo("s");											
				String a116 = comm.listDolgozo();
				String a117 = comm.listAkadaly();							
				String a118 = comm.listLada();	
				String a119 = comm.ListCelmezo();
				String a120 = a112 + a113 + a114 + a115 + a116 + a117 + a118 + a119;
				comm.CompareTest(a120, 19);
				break;
		case 20:
				comm.loadMap("Test6");				
				String a121 = comm.listDolgozo();		
				comm.GiveUp(0);
				comm.moveDolgozo("s");															
				String a122 = comm.listDolgozo();	
				String a123 = a121 + a122;
				comm.CompareTest(a123, 20);
				break;
		case 21:
				comm.loadMap("Test6");
				comm.EndGame();
				break;
		case 22:
				comm.loadMap("Test6");
				String a124 = comm.listDolgozo();
				String a125 = comm.listMez();
				comm.placeMez();
				String a126 = comm.listDolgozo();
				String a127 = comm.listMez();
				String a128 = a124 + a125 + a126 + a127;
				comm.CompareTest(a128, 22);
				break;
		case 23:
				comm.loadMap("Test6");
				String a129 = comm.listDolgozo();
				String a130 = comm.listOlaj();
				comm.placeOlaj();
				String a131 = comm.listDolgozo();
				String a132 = comm.listOlaj();
				String a133 = a129 + a130 + a131 + a132;
				comm.CompareTest(a133, 23);
				break;		
	/*	case 24:
				Scanner tmp = new Scanner(System.in);
				String sgd = tmp.nextLine();
				comm.FajlBolParancs(sgd);
				break;*/
		default:
				break;
		}		
	}
}
