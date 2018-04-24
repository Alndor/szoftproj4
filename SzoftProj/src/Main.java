import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Main {

	public static void main(String args[]) {
		/*
		while(true) {
			
			//kezdeti objektumok létrehozása
			
			
			Iranyok irany = Iranyok.RIGHT;
			
			Iranyok noMove = Iranyok.NOTHING;
			
			Game g = new Game();
			
			Mezo uresmezo = new Mezo();
			Mezo ladasmezo1 = new Mezo();
			Mezo ladasmezo2 = new Mezo();
			Mezo ladasmezo3 = new Mezo();
			Mezo dolgozosmezo1 = new Mezo();
			Mezo dolgozosmezo2 = new Mezo();
			Mezo kapcsolosmezo = new Mezo();
			Mezo celmezosmezo = new Mezo();
			Mezo lyukasmezo = new Mezo();
			Mezo kapcslyukmezo = new Mezo();
			Mezo akadalyosmezo = new Mezo();
			
			Lada lada1 = new Lada();
			Lada lada2 = new Lada();
			Lada lada3 = new Lada();
			
			Dolgozo dolgozo1 = new Dolgozo();
			Dolgozo dolgozo2 = new Dolgozo();
			dolgozo1.Save();
			
			Lyuk lyuk1 = new Lyuk();
			Lyuk kapcslyuk = new Lyuk();
			lyuk1.Save();
			kapcslyuk.Save();
			
			Kapcsolo kapcsolo = new Kapcsolo();
			
			CelMezo celmezo = new CelMezo();
			
			Akadaly akadaly = new Akadaly();
			
			ladasmezo1.Accept(lada1);
			ladasmezo2.Accept(lada2);
			ladasmezo3.Accept(lada3);
			dolgozosmezo1.Accept(dolgozo1);
			dolgozosmezo2.Accept(dolgozo2);
			kapcsolosmezo.Accept(kapcsolo);
			celmezosmezo.Accept(celmezo);
			lyukasmezo.Accept(lyuk1);
			akadalyosmezo.Accept(akadaly);
			
			//fõmenü
			System.out.println("\n\n");
			System.out.println("1.: Dolgozó mozgatása");
			System.out.println("2.: Láda mozgatása");
			System.out.println("3.: Lyukra lépés");
			System.out.println("4.: Falhoz lépés");
			System.out.println("5.: Kapcsolóra lépés");
			System.out.println("6.: Célmezõre lépés");
			System.out.println("7.: Láncolt mozgás");
			System.out.println("8.: Kilépés");
			System.out.println("\n? Adja meg a parancs kódját!");
			
			Scanner sc0 = new Scanner(System.in);
			int k0 = sc0.nextInt();
			
			switch(k0) {
			case 1: 
					System.out.println("- 1.: Dolgozó mozgatása");
					System.out.println("-\t1.1: Mozogni akar egy irányba?");
					System.out.println("-\t1.2: Tolják egy irányba?");
					System.out.println("-\t1.3: Nem mozog?");
					System.out.println("\n? Adja meg a parancs kódját!");
					Scanner sc1 = new Scanner(System.in);
					int k1 = sc1.nextInt();
					
					switch(k1) {
					case 1:
							System.out.println("-\t1.1: Üres mezõre lép?");
							System.out.println("-\t\t1.1.1: Igen.");
							System.out.println("-\t\t1.1.2: Nem.");
							System.out.println("\n? Adja meg a parancs kódját!");
							Scanner sc11 = new Scanner(System.in);
							int k11 = sc11.nextInt();
							
							switch (k11) {
							case 1:
								//dolgozó üres mezõre lép
								dolgozosmezo1.SetNeighbor(irany, uresmezo);
								dolgozo1.Move(irany);
									break;
							
							case 2:
									System.out.println("-\t\t1.1.2: Mi van a mezõn?");
									System.out.println("-\t\t\t1.1.2.1: Dolgozó.");
									System.out.println("-\t\t\t1.1.2.2: Láda.");
									System.out.println("-\t\t\t1.1.2.3: Lyuk.");
									System.out.println("-\t\t\t1.1.2.4: Célmezõ.");
									System.out.println("-\t\t\t1.1.2.5: Kapcsoló.");
									System.out.println("-\t\t\t1.1.2.6: Fal.");
									System.out.println("\n? Adja meg a parancs kódját!");
									Scanner sc111 = new Scanner(System.in);
									int k111 = sc111.nextInt();
								
									switch (k111) {
									case 1: //dolgozó dolgozós mezõre lép
											dolgozo1.GetCurrent().SetNeighbor(irany, dolgozosmezo2);
											dolgozo2.GetCurrent().SetNeighbor(irany, uresmezo);
											dolgozo1.Move(irany);
											
											
											break;
									case 2:	//dolgozó ládás mezõre lép								
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, uresmezo);
										dolgozo1.Move(irany);
											break;
									case 3: //dolgozó lyukas mezõre lép										
										dolgozo1.GetCurrent().SetNeighbor(irany, lyukasmezo);
										lyuk1.GetCurrent().SetNeighbor(irany, uresmezo);
										dolgozo1.Move(irany);
											break;
									case 4: //dolgozó célmezõre lép									
										dolgozo1.GetCurrent().SetNeighbor(irany, celmezosmezo);
										celmezo.GetCurrent().SetNeighbor(irany, uresmezo);
										dolgozo1.Move(irany);
											break;
									case 5: //dolgozó kapcsolós mezõre lép									
										dolgozo1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
										kapcsolo.GetCurrent().SetNeighbor(irany, uresmezo);
										dolgozo1.Move(irany);
											break;
									case 6: //dolgozó falra lép									
										dolgozo1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
										akadaly.GetCurrent().SetNeighbor(irany, uresmezo);
										dolgozo1.Move(irany);
											break;
									default:
											break;
								}	
									
							}
							break;
					case 2:
						System.out.println("-\t1.2: Üres mezõre tolják?");
						System.out.println("-\t\t1.2.1: Igen.");
						System.out.println("-\t\t1.2.2: Nem.");
						System.out.println("\n? Adja meg a parancs kódját!");
						Scanner sc12 = new Scanner(System.in);
						int k12 = sc12.nextInt();
						
						switch (k12) {
						case 1:	//dolgozót üres mezõre tolják
							dolgozosmezo1.SetNeighbor(irany, uresmezo);
							dolgozo1.HitByLada(lada1, irany);
								break;
						case 2:
								System.out.println("-\t\t1.2.2: Mivan a mezõn?");
								System.out.println("-\t\t\t1.2.2.1: Dolgozó.");
								System.out.println("-\t\t\t1.2.2.2: Láda.");
								System.out.println("-\t\t\t1.2.2.3: Lyuk.");
								System.out.println("-\t\t\t1.2.2.4: Célmezõ.");
								System.out.println("-\t\t\t1.2.2.5: Kapcsoló.");
								System.out.println("-\t\t\t1.2.2.6: Fal.");
								System.out.println("\n? Adja meg a parancs kódját!");
								Scanner sc112 = new Scanner(System.in);
								int k112 = sc112.nextInt();
							
								switch (k112) {
								case 1: //dolgozót dolgozós mezõre tolják								
									dolgozo1.GetCurrent().SetNeighbor(irany, dolgozosmezo2);
									dolgozo2.GetCurrent().SetNeighbor(irany, uresmezo);
									dolgozo1.HitByLada(lada1, irany);
										break;
								case 2:	//dolgozót ládás mezõre tolják							
									dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo2);
									lada2.GetCurrent().SetNeighbor(irany, uresmezo);
									dolgozo1.HitByLada(lada1, irany);
										break;
								case 3: //dolgozót lyukas mezõre tolják							
									dolgozo1.GetCurrent().SetNeighbor(irany, lyukasmezo);
									lyuk1.GetCurrent().SetNeighbor(irany, uresmezo);
									dolgozo1.HitByLada(lada1, irany);
										break;
								case 4: //dolgozót célmezõre tolják								
									dolgozo1.GetCurrent().SetNeighbor(irany, celmezosmezo);
									celmezo.GetCurrent().SetNeighbor(irany, uresmezo);
									dolgozo1.HitByLada(lada1, irany);
										break;
								case 5: //dolgozót kapcsolós mezõre tolják								
									dolgozo1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
									kapcsolo.GetCurrent().SetNeighbor(irany, uresmezo);
									dolgozo1.HitByLada(lada1, irany);
										break;
								case 6: //dolgozót falra tolják									
									dolgozo1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
									akadaly.GetCurrent().SetNeighbor(irany, uresmezo);
									dolgozo1.HitByLada(lada1, irany);
										break;
								default:
										break;
								}
								break;
							}
							break;
					case 3: //dolgozó nem mozdul
							dolgozo1.Move(noMove);
							break;
					default:
							break;
					}
					break;
					
					
			case 2:
					System.out.println("- 2.: Láda mozgatása");
					System.out.println("-\t2.1: Dolgozó tolja a ládát?");
					System.out.println("-\t2.2: Láda tolja a ládát?");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc2 = new Scanner(System.in);
					int k2 = sc2.nextInt();
					
					switch (k2) {
					case 1:
							System.out.println("-\t2.1: Üres mezõre tolják?");
							System.out.println("-\t\t2.1.1: Igen.");
							System.out.println("-\t\t2.1.2: Nem.");
							System.out.println("\n Adja meg a parancs kódját!");
							Scanner sc21 = new Scanner(System.in);
							int k21 = sc21.nextInt();
							
							switch (k21) {
							case 1:
								//üres mezõre tolt dobozt a dolgozó
								dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
								lada1.GetCurrent().SetNeighbor(irany, uresmezo);
								lada1.HitByDolgozo(dolgozo1, irany);
								
									break;
							case 2://nem üres mezõre tolt dolgozó ládát
									System.out.println("-\t\t2.1.2: Mi van a mezõn?");
									System.out.println("-\t\t\t2.1.2.1: Dolgozó.");
									System.out.println("-\t\t\t2.1.2.2: Láda.");
									System.out.println("-\t\t\t2.1.2.3: Lyuk.");
									System.out.println("-\t\t\t2.1.2.4: Célmezõ.");
									System.out.println("-\t\t\t2.1.2.5: Kapcsoló.");
									System.out.println("-\t\t\t2.1.2.6: Fal.");
									System.out.println("\n Adja meg a parancs kódját!");
									Scanner sc212 = new Scanner(System.in);
									int k212 = sc212.nextInt();
									
									switch (k212) {
									case 1:	//dolgozós mezõre tolt dolgozó ládát
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, dolgozosmezo2);
										lada1.HitByDolgozo(dolgozo1, irany);
										
											break;
									case 2:	//ládás mezõre tolt dolgozó ládát
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, ladasmezo2);
										lada2.GetCurrent().SetNeighbor(irany, uresmezo);
										lada1.HitByDolgozo(dolgozo1, irany);
										
											break;
									case 3:	//lyukas mezõre tolt dolgozó ládát
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, lyukasmezo);
										lyuk1.GetCurrent().SetNeighbor(irany, uresmezo);
										lada1.HitByDolgozo(dolgozo1, irany);
											break;
									case 4:	//célmezõs mezõre tolt dolgozó ládát
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, celmezosmezo);
										celmezo.GetCurrent().SetNeighbor(irany, uresmezo);
										lada1.HitByDolgozo(dolgozo1, irany);
										
											break;
									case 5:	//kapcsolós mezõre tolt dolgozó ládát
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
										kapcsolo.GetCurrent().SetNeighbor(irany, uresmezo);
										lada1.HitByDolgozo(dolgozo1, irany);
											break;
									case 6:	//falas mezõre tolt dolgozó ládát
										dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
										lada1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
										akadaly.GetCurrent().SetNeighbor(irany, uresmezo);
										lada1.HitByDolgozo(dolgozo1, irany);
											break;
									default:
											break;
									}
									break;
							default:
									break;
							}
							break;
					case 2:
							System.out.println("-\t2.2: Üres mezõre tolják?");
							System.out.println("-\t\t2.2.1: Igen.");
							System.out.println("-\t\t2.2.2: Nem.");
							System.out.println("\n Adja meg a parancs kódját!");
							Scanner sc22 = new Scanner(System.in);
							int k22 = sc22.nextInt();
						
							switch (k22) {
							case 1://üres mezõre tolt láda ládát
								lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
								lada1.GetCurrent().SetNeighbor(irany, uresmezo);
								lada1.HitByLada(lada2, irany);
									
									break;
							case 2://nem üres mezõre tolt láda ládát
								System.out.println("-\t\t2.2.2: Mivan a mezõn?");
								System.out.println("-\t\t\t2.2.2.1: Dolgozó.");
								System.out.println("-\t\t\t2.2.2.2: Láda.");
								System.out.println("-\t\t\t2.2.2.3: Lyuk.");
								System.out.println("-\t\t\t2.2.2.4: Célmezõ.");
								System.out.println("-\t\t\t2.2.2.5: Kapcsoló.");
								System.out.println("-\t\t\t2.2.2.6: Fal.");
								System.out.println("\n Adja meg a parancs kódját!");
								Scanner sc222 = new Scanner(System.in);
								int k222 = sc222.nextInt();
								
								switch (k222) {
								case 1:	//dolgozós mezõre tolt láda ládát
									lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
									lada1.GetCurrent().SetNeighbor(irany, dolgozosmezo1);
									dolgozo1.GetCurrent().SetNeighbor(irany, uresmezo);
									lada1.HitByLada(lada2, irany);
										break;
								case 2:	//ládás mezõre tolt láda ládát
									lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
									lada1.GetCurrent().SetNeighbor(irany, ladasmezo3);
									lada3.GetCurrent().SetNeighbor(irany, uresmezo);
									lada1.HitByLada(lada2, irany);
										break;
								case 3:	//lyukas mezõre tolt láda ládát
									lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
									lada1.GetCurrent().SetNeighbor(irany, lyukasmezo);
									lyuk1.GetCurrent().SetNeighbor(irany, uresmezo);
									lada1.HitByLada(lada2, irany);
										break;
								case 4:	//célmezõs mezõre tolt láda ládát
									lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
									lada1.GetCurrent().SetNeighbor(irany, celmezosmezo);
									celmezo.GetCurrent().SetNeighbor(irany, uresmezo);
									lada1.HitByLada(lada2, irany);
										break;
								case 5:	//kapcsolós mezõre tolt láda ládát
									lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
									lada1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
									kapcsolo.GetCurrent().SetNeighbor(irany, uresmezo);
									lada1.HitByLada(lada2, irany);
										break;
								case 6:	//falas mezõre tolt láda ládát
									lada2.GetCurrent().SetNeighbor(irany, ladasmezo1);
									lada1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
									lada1.HitByLada(lada2, irany);
										break;
								default:
										break;
								}
								break;
							default:
								break;
							}
							break;
					default:
							break;
					}
					break;
			case 3:
				System.out.println("- 3.: Lyukra lépés");
				System.out.println("-		3.1: Láda kerül a lyukra?");
				System.out.println("-		3.2: Dolgozó kerül a lyukra?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc3 = new Scanner(System.in);
				int k3 = sc3.nextInt();
				
				switch (k3) {
				case 1:	
					lada1.GetCurrent().SetNeighbor(irany, lyukasmezo);
					lada1.HitByDolgozo(dolgozo1, irany);
						break;
				case 2:	
					dolgozo1.GetCurrent().SetNeighbor(irany, lyukasmezo);
					dolgozo1.Move(irany);
						break;
				default:
						break;
				}
				break;
		case 4:
				System.out.println("- 4.: Falhoz lépés");
				System.out.println("-		4.1: Dolgozó lép falhoz?");
				System.out.println("-		4.2: Dolgozót toltak a falnak?");
				System.out.println("-		4.3: Ládátt toltak a falnak?");
				System.out.println("\n Adja meg a parancs kódját!");		
				
				Scanner sc4 = new Scanner(System.in);
				int k4 = sc4.nextInt();
				
				switch (k4) {
				case 1:
					dolgozo1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
					dolgozo1.Move(irany);
					break;
				case 2:
					dolgozo1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
					dolgozo1.HitByDolgozo(dolgozo2, irany);
						break;
				case 3:
					lada1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
					lada1.HitByDolgozo(dolgozo1, irany);
						break;
				default:
						break;
				}
				break;
		case 5:
				System.out.println("- 5.: Kapcsolóra lépés");
				System.out.println("-		5.1: Láda kerül a kapcsolóra?");
				System.out.println("-		5.2: Dolgozó kerül a kapcsolóra?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc5 = new Scanner(System.in);
				int k5 = sc5.nextInt();
			
				switch (k5) {
				case 1:	
					lada1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
					lada1.HitByDolgozo(dolgozo1, irany);
					break;
				case 2:	
					dolgozo1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
					dolgozo1.Move(irany);
					break;
				default:
						break;
				}
				break;
		case 6:
				System.out.println("- 6.: Célmezõre lépés");
				System.out.println("-		6.1: Láda kerül a célmezõre?");
				System.out.println("-		6.2: Dolgozó kerül a célmezõre?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc6 = new Scanner(System.in);
				int k6 = sc6.nextInt();
			
				switch (k6) {
				case 1:	
					lada1.GetCurrent().SetNeighbor(irany, celmezosmezo);
					lada1.HitByDolgozo(dolgozo1, irany);
					break;
				case 2:	
					dolgozo1.GetCurrent().SetNeighbor(irany, celmezosmezo);
					dolgozo1.Move(irany);
					break;
				default:
						break;
				}
				break;
		case 7:
			System.out.println("- 7.: Láncolt mozgás");
			System.out.println("-		7.1: Dolgozó?");
			System.out.println("-		7.2: Láda?");
			System.out.println("\n Adja meg a parancs kódját!");					
			Scanner sc7 = new Scanner(System.in);
			int k7 = sc7.nextInt();
		
			switch (k7) {
			case 1:	
				dolgozo1.GetCurrent().SetNeighbor(irany, dolgozosmezo2);
				
				System.out.println("- 	7.1: Mire lépjen?");
				System.out.println("-			7.1.1: Mezo?");
				System.out.println("-			7.2.1: Láda?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc71 = new Scanner(System.in);
				int k71 = sc71.nextInt();
				
				switch(k71) {
				case 1:
					System.out.println("-			7.1.1: Mivan a mezõn?");
					System.out.println("-			7.1.1.1: Lyuk.");
					System.out.println("-			7.1.1.2: Célmezõ.");
					System.out.println("-			7.1.1.3: Kapcsoló.");
					System.out.println("-			7.1.1.4: Fal.");
					System.out.println("-			7.1.1.5: Üres.");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc711 = new Scanner(System.in);
					int k711 = sc711.nextInt();
					
					switch (k711) {
					case 1:									
						dolgozo2.GetCurrent().SetNeighbor(irany, lyukasmezo);
						dolgozo1.Move(irany);
							break;
					case 2: 									
						dolgozo2.GetCurrent().SetNeighbor(irany, celmezosmezo);
						dolgozo1.Move(irany);
							break;
					case 3: 									
						dolgozo2.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
						dolgozo1.Move(irany);
							break;
					case 4: 									
						dolgozo2.GetCurrent().SetNeighbor(irany, akadalyosmezo);
						dolgozo1.Move(irany);
							break;
					case 5:
						dolgozo2.GetCurrent().SetNeighbor(irany, uresmezo);
						dolgozo1.Move(irany);
							break;
					default:
							break;
					}
					break;
				case 2:
					dolgozo2.GetCurrent().SetNeighbor(irany, ladasmezo1);
					
					System.out.println("-				7.1.1.1: Mivan a mezõn?");
					System.out.println("-				7.1.1.1.1: Lyuk.");
					System.out.println("-				7.1.1.1.2: Célmezõ.");
					System.out.println("-				7.1.1.1.3: Kapcsoló.");
					System.out.println("-				7.1.1.1.4: Fal.");
					System.out.println("-				7.1.1.1.5: Üres.");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc7111 = new Scanner(System.in);
					int k7111 = sc7111.nextInt();
					
					switch(k7111) {
					case 1:
						lada1.GetCurrent().SetNeighbor(irany, lyukasmezo);
						dolgozo1.Move(irany);
						break;
					case 2:
						lada1.GetCurrent().SetNeighbor(irany, celmezosmezo);
						dolgozo1.Move(irany);
						break;
					case 3:
						lada1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
						dolgozo1.Move(irany);
						break;
					case 4:
						lada1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
						dolgozo1.Move(irany);
						break;
					case 5:
						lada1.GetCurrent().SetNeighbor(irany, uresmezo);
						dolgozo1.Move(irany);
						break;
					default:
						break;
					}
						break;
				
				default:
					break;
				}
				break;
			case 2:	
				dolgozo1.GetCurrent().SetNeighbor(irany, ladasmezo1);
				
				System.out.println("- 	7.2: Mire lépjen?");
				System.out.println("-			7.2.1: Mezo?");
				System.out.println("-			7.2.1: Láda?");
				System.out.println("-			7.2.1: Dolgozó?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc72 = new Scanner(System.in);
				int k72 = sc72.nextInt();
				
				switch(k72) {
				case 1:
					System.out.println("-			7.2.1: Mivan a mezõn?");
					System.out.println("-			7.2.1.1: Láda.");
					System.out.println("-			7.2.1.2: Lyuk.");
					System.out.println("-			7.2.1.3: Célmezõ.");
					System.out.println("-			7.2.1.4: Kapcsoló.");
					System.out.println("-			7.2.1.5: Fal.");
					System.out.println("-			7.2.1.6: Üres.");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc721 = new Scanner(System.in);
					int k721 = sc721.nextInt();
					
					switch (k721) {
					case 1: 									
						lada1.GetCurrent().SetNeighbor(irany, ladasmezo2);
						
						System.out.println("-				7.2.1.1: Mivan a mezõn?");
						System.out.println("-				7.2.1.1.1: Lyuk.");
						System.out.println("-				7.2.1.1.2: Célmezõ.");
						System.out.println("-				7.2.1.1.3: Kapcsoló.");
						System.out.println("-				7.2.1.1.4: Fal.");
						System.out.println("-				7.2.1.1.5: Üres.");
						System.out.println("\n Adja meg a parancs kódját!");
						Scanner sc7211 = new Scanner(System.in);
						int k7211 = sc7211.nextInt();
						
						switch(k7211) {
						case 1:
							lada2.GetCurrent().SetNeighbor(irany, lyukasmezo);
							dolgozo1.Move(irany);
							break;
						case 2:
							lada2.GetCurrent().SetNeighbor(irany, celmezosmezo);
							dolgozo1.Move(irany);
							break;
						case 3:
							lada2.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
							dolgozo1.Move(irany);
							break;
						case 4:
							lada2.GetCurrent().SetNeighbor(irany, akadalyosmezo);
							dolgozo1.Move(irany);
							break;
						case 5:
							lada2.GetCurrent().SetNeighbor(irany, uresmezo);
							dolgozo1.Move(irany);
							break;
						default:
							break;
						}
							break;
					case 2:									
						lada1.GetCurrent().SetNeighbor(irany, lyukasmezo);
						dolgozo1.Move(irany);
							break;
					case 3: 									
						lada1.GetCurrent().SetNeighbor(irany, celmezosmezo);
						dolgozo1.Move(irany);
							break;
					case 4: 									
						lada1.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
						dolgozo1.Move(irany);
							break;
					case 5: 									
						lada1.GetCurrent().SetNeighbor(irany, akadalyosmezo);
						dolgozo1.Move(irany);
							break;
					case 6:
						lada1.GetCurrent().SetNeighbor(irany, uresmezo);
						dolgozo1.Move(irany);
							break;
					default:
							break;
					}
					break;
				case 2:
					lada1.GetCurrent().SetNeighbor(irany, ladasmezo2);
					
					System.out.println("-				7.2.2: Mivan a mezõn?");
					System.out.println("-				7.2.2.1: Lyuk.");
					System.out.println("-				7.2.2.2: Célmezõ.");
					System.out.println("-				7.2.2.3: Kapcsoló.");
					System.out.println("-				7.2.2.4: Fal.");
					System.out.println("-				7.2.2.5: Üres.");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc7221 = new Scanner(System.in);
					int k7221 = sc7221.nextInt();
					
					switch(k7221) {
					case 1:
						lada2.GetCurrent().SetNeighbor(irany, lyukasmezo);
						dolgozo1.Move(irany);
						break;
					case 2:
						lada2.GetCurrent().SetNeighbor(irany, celmezosmezo);
						dolgozo1.Move(irany);
						break;
					case 3:
						lada2.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
						dolgozo1.Move(irany);
						break;
					case 4:
						lada2.GetCurrent().SetNeighbor(irany, akadalyosmezo);
						dolgozo1.Move(irany);
						break;
					case 5:
						lada2.GetCurrent().SetNeighbor(irany, uresmezo);
						dolgozo1.Move(irany);
						break;
					default:
						break;
					}
						break;
				default:
					break;
				}
			case 3:
				lada1.GetCurrent().SetNeighbor(irany, dolgozosmezo2);
				
				System.out.println("- 	7.3: Mire lépjen?");
				System.out.println("-			7.3.1: Mezo?");
				System.out.println("-			7.3.1: Láda?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc73 = new Scanner(System.in);
				int k73 = sc73.nextInt();
				
				switch(k73) {
				case 1:
					System.out.println("-			7.3.1: Mivan a mezõn?");
					System.out.println("-			7.3.1.1: Lyuk.");
					System.out.println("-			7.3.1.2: Célmezõ.");
					System.out.println("-			7.3.1.3: Kapcsoló.");
					System.out.println("-			7.3.1.4: Fal.");
					System.out.println("-			7.3.1.5: Üres.");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc731 = new Scanner(System.in);
					int k731 = sc731.nextInt();
					
					switch (k731) {
					case 1:									
						dolgozo2.GetCurrent().SetNeighbor(irany, lyukasmezo);
						dolgozo1.Move(irany);
							break;
					case 2: 									
						dolgozo2.GetCurrent().SetNeighbor(irany, celmezosmezo);
						dolgozo1.Move(irany);
							break;
					case 3: 									
						dolgozo2.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
						dolgozo1.Move(irany);
							break;
					case 4: 									
						dolgozo2.GetCurrent().SetNeighbor(irany, akadalyosmezo);
						dolgozo1.Move(irany);
							break;
					case 5:
						dolgozo2.GetCurrent().SetNeighbor(irany, uresmezo);
						dolgozo1.Move(irany);
							break;
					default:
							break;
					}
					break;
				case 2:
					lada1.GetCurrent().SetNeighbor(irany, ladasmezo2);
					
					System.out.println("-				7.3.1.2: Mivan a mezõn?");
					System.out.println("-				7.3.1.2.1: Lyuk.");
					System.out.println("-				7.3.1.2.2: Célmezõ.");
					System.out.println("-				7.3.1.2.3: Kapcsoló.");
					System.out.println("-				7.3.1.2.4: Fal.");
					System.out.println("-				7.3.1.2.5: Üres.");
					System.out.println("\n Adja meg a parancs kódját!");
					Scanner sc7321 = new Scanner(System.in);
					int k7321 = sc7321.nextInt();
					
					switch(k7321) {
					case 1:
						lada2.GetCurrent().SetNeighbor(irany, lyukasmezo);
						dolgozo1.Move(irany);
						break;
					case 2:
						lada2.GetCurrent().SetNeighbor(irany, celmezosmezo);
						dolgozo1.Move(irany);
						break;
					case 3:
						lada2.GetCurrent().SetNeighbor(irany, kapcsolosmezo);
						dolgozo1.Move(irany);
						break;
					case 4:
						lada2.GetCurrent().SetNeighbor(irany, akadalyosmezo);
						dolgozo1.Move(irany);
						break;
					case 5:
						lada2.GetCurrent().SetNeighbor(irany, uresmezo);
						dolgozo1.Move(irany);
						break;
					default:
						break;
					}
						break;
				
				default:
					break;
				}					
					
			default:
					break;
			}
				break;
		case 8:
				System.out.println("- 8.: Kilépés");
				System.out.println("-		8.1: Nyerés?");
				System.out.println("-		8.2: Feladás?");
				System.out.println("-		8.3: Kilépés a programból?");
				System.out.println("\n Adja meg a parancs kódját!");					
				Scanner sc8 = new Scanner(System.in);
				int k8 = sc8.nextInt();
			
				switch (k8) {
				case 1:	
					g.EndGame();
					return;
				case 2:	
					dolgozo1.GiveUp();
					return;
				case 3:	
					return;
						
				default:
						break;
				}
					break;
			
			}
			System.out.println("\n\n");
		}
		*/
		
		//kiirtest();
		//olvastest();
		
		Map map = new Map();
		map.Load("Test5.txt");
		map.Save("Test5.txt");
	}
	
	private static void olvastest() {
		Map ma = new Map();
		ma.Load("map2.txt");
		
		ma.Save("map.txt");
	}

	private static void kiirtest() {
		Map map = new Map();
		Akadaly a = new Akadaly();
		Mezo am = new Mezo();
		am.Accept(a);
		
		Mezo m = new Mezo();
		
		Dolgozo d = new Dolgozo();
		
		Lada l = new Lada();
		Mez mez = new Mez();
		Olaj olaj = new Olaj();
		
		Mezo lm = new Mezo();
		lm.Accept(mez);
		lm.Accept(l);
		
		Mezo lo = new Mezo();
		lo.Accept(olaj);
		lo.Accept(l);
		
		Mezo ml = new Mezo();
		ml.Accept(l);
		l.SetWeight(7);
		
		Mezo md = new Mezo();
		md.Accept(d);
		
		Lada l2 = new Lada();
		l2.SetWeight(15);
		Mezo ml2 = new Mezo();
		ml2.Accept(l2);
		
		CelMezo c = new CelMezo();
		Mezo cm = new Mezo();
		cm.Accept(c);
		
		Lyuk ly = new Lyuk();
		Mezo lym = new Mezo();
		lym.Accept(ly);
		lym.setMap(map);
		
		Kapcsolo k = new Kapcsolo();
		Mezo kl = new Mezo();
		k.SetSegedLyuk(ly);
		k.SetLyukable(lym);
		kl.Accept(k);
		kl.Accept(l);
		
		Mezo km = new Mezo();
		km.Accept(k);
		
		Dolgozo d2 = new Dolgozo();
		Mezo md2 = new Mezo();
		md2.Accept(d2);
		
		d.setStrength(20);
		
		ArrayList<Item> itemek = new ArrayList<Item>();
		itemek.add(olaj);
		itemek.add(mez);
		
		d.SetItems(itemek);
		
		map.addDolgozo(d);
		map.addMezo(0, 0, am);
		map.addMezo(0, 1, am);
		map.addMezo(0, 2, am);
		map.addMezo(0, 3, am);
		map.addMezo(0, 4, am);
		map.addMezo(0, 5, am);
		map.addMezo(0, 6, am);
//		map.addMezo(0, 7, am);
//		map.addMezo(0, 8, am);
		map.addMezo(1, 0, am);
		map.addMezo(1, 1, am);
		map.addMezo(1, 2, am);
		map.addMezo(1, 3, md);
		map.addMezo(1, 4, am);
		map.addMezo(1, 5, am);
		map.addMezo(1, 6, am);
//		map.addMezo(1, 7, m);
//		map.addMezo(1, 8, am);
		map.addMezo(2, 0, am);
		map.addMezo(2, 1, m);
		map.addMezo(2, 2, m);
		map.addMezo(2, 3, ml);
		map.addMezo(2, 4, m);
		map.addMezo(2, 5, m);
		map.addMezo(2, 6, am);
//		map.addMezo(2, 7, am);
//		map.addMezo(2, 8, am);
		map.addMezo(3, 0, am);
		map.addMezo(3, 1, am);
		map.addMezo(3, 2, ml);
		map.addMezo(3, 3, am);
		map.addMezo(3, 4, am);
		map.addMezo(3, 5, am);
		map.addMezo(3, 6, am);
//		map.addMezo(3, 7, am);
//		map.addMezo(3, 8, am);
		map.addMezo(4, 0, am);
		map.addMezo(4, 1, am);
		map.addMezo(4, 2, am);
		map.addMezo(4, 3, cm);
		map.addMezo(4, 4, am);
		map.addMezo(4, 5, am);
		map.addMezo(4, 6, am);
//		map.addMezo(4, 7, am);
//		map.addMezo(4, 8, am);
		map.addMezo(5, 0, am);
		map.addMezo(5, 1, am);
		map.addMezo(5, 2, am);
		map.addMezo(5, 3, am);
		map.addMezo(5, 4, am);
		map.addMezo(5, 5, am);
		map.addMezo(5, 6, am);
//		map.addMezo(5, 7, am);
//		map.addMezo(5, 8, am);
		
		map.SetTreeMap();
		map.createNeighbourhood();
		map.Save("Test6.txt");
		
	}
}
